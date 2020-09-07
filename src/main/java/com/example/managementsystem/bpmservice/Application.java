package com.example.managementsystem.bpmservice;

import com.example.managementsystem.bpmservice.authentication.AuthenticatedLoggedInUser;
import com.example.managementsystem.bpmservice.authentication.AuthenticationUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashMap;

@RestController
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    //    @PreAuthorize("hasAuthority('CREATE_BUNDLE')")
    @GetMapping(path = "/test")
    public ResponseEntity<AuthenticationUser> test(@AuthenticatedLoggedInUser AuthenticationUser user) {
        return ResponseEntity.ok(user);
    }

    @Bean
    public PrincipalExtractor principalExtractor() {
        return (map) -> {
            AuthenticationUser myUser = new AuthenticationUser();
            myUser.setUsername(map.get("username").toString());
            myUser.setClient(map.get("client").toString());
            myUser.setRole(map.get("role").toString());
            ArrayList<GrantedAuthority> authorities = new ArrayList<>();
            try {
                for (LinkedHashMap grantedAuthority : (ArrayList<LinkedHashMap>) map.get("authorities")) {
                    authorities.add(new SimpleGrantedAuthority(grantedAuthority.get("authority").toString()));
                }
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            myUser.setAuthorities(authorities);
            return myUser;
        };
    }
}
