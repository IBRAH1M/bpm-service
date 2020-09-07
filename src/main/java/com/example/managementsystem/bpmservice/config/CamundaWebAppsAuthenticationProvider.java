//package com.example.managementsystem.bpmservice.config;
//
//import org.camunda.bpmservice.engine.ProcessEngine;
//import org.camunda.bpmservice.engine.rest.security.auth.AuthenticationResult;
//import org.camunda.bpmservice.engine.rest.security.auth.impl.ContainerBasedAuthenticationProvider;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class CamundaWebAppsAuthenticationProvider extends ContainerBasedAuthenticationProvider {
//
//    @Override
//    public AuthenticationResult extractAuthenticatedUser(HttpServletRequest request, ProcessEngine engine) {
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if (authentication == null) {
//            return AuthenticationResult.unsuccessful();
//        }
//
//        String name = authentication.getName();
//        if (name == null || name.isEmpty()) {
//            return AuthenticationResult.unsuccessful();
//        }
//
//        AuthenticationResult authenticationResult = new AuthenticationResult(name, true);
//        authenticationResult.setGroups(getUserGroups(authentication));
//
//        return authenticationResult;
//    }
//
//    private List<String> getUserGroups(Authentication authentication){
//        return authentication.getAuthorities().stream()
//                .map(res -> res.getAuthority())
//                .map(res -> res.split("_")[1]) // Strip "ROLE_"
//                .collect(Collectors.toList());
//    }
//}
