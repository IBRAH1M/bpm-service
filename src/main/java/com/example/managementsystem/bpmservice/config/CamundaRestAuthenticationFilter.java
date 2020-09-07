package com.example.managementsystem.bpmservice.config;

import com.example.managementsystem.bpmservice.authentication.AuthenticationUser;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.rest.util.EngineUtil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CamundaRestAuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Current limitation: Only works for the default engine
        ProcessEngine engine = EngineUtil.lookupProcessEngine("default");
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AuthenticationUser authenticationUser;

        if (principal instanceof AuthenticationUser) {
            authenticationUser = ((AuthenticationUser) principal);
        } else {
            authenticationUser = new AuthenticationUser();
            authenticationUser.setUsername(principal.toString());
        }

        try {
            engine.getIdentityService().setAuthentication(authenticationUser.getUsername(), getUserGroups(authenticationUser), Collections.singletonList(authenticationUser.getClient()));
            chain.doFilter(request, response);
        } finally {
            clearAuthentication(engine);
        }
    }

    private void clearAuthentication(ProcessEngine engine) {
        engine.getIdentityService().clearAuthentication();
    }

    private List<String> getUserGroups(AuthenticationUser authentication) {
        return authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
//                .map(res -> res.split("_")[1]) // Strip the authority only "*_AUTHORITY"
                .collect(Collectors.toList());
    }
}
