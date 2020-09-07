//package com.example.managementsystem.bpmservice.config;
//
//import org.camunda.bpmservice.webapp.impl.security.auth.ContainerBasedAuthenticationFilter;
//import org.springframework.boot.autoconfigure.security.SecurityProperties;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//import java.util.Collections;
//
//@EnableWebSecurity
//@Configuration
//@Order(SecurityProperties.BASIC_AUTH_ORDER - 15)
//public class CamundaWebAppsSecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .antMatcher("/app/**")
//                .authorizeRequests().anyRequest().authenticated()
//                .and()
//                .httpBasic();// this is just an example, use any auth mechanism you like
//    }
//
//    @Bean
//    public FilterRegistrationBean<ContainerBasedAuthenticationFilter> containerBasedAuthenticationFilter(){
//
//        FilterRegistrationBean<ContainerBasedAuthenticationFilter> filterRegistration = new FilterRegistrationBean<>();
//        filterRegistration.setFilter(new ContainerBasedAuthenticationFilter());
//        filterRegistration.setInitParameters(Collections.singletonMap("authentication-provider", "com.example.managementsystem.bpmservice.config.CamundaWebAppsAuthenticationProvider"));
//        filterRegistration.setOrder(101); // make sure the filter is registered after the Spring Security Filter Chain
//        filterRegistration.addUrlPatterns("/app/*");
//        return filterRegistration;
//    }
//}
