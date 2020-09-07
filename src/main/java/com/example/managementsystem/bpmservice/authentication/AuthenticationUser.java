package com.example.managementsystem.bpmservice.authentication;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class AuthenticationUser {

    public AuthenticationUser() {
    }

    private String client;
    private String username;
    private String role;
    private Collection<? extends GrantedAuthority> authorities;

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
}
