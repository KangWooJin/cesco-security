package com.github.bakery.cesco.week05;

import java.util.UUID;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableWebSecurity
public class Week05SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.logout().addLogoutHandler((request, response, authentication) -> {
            log.info("request", request);
            log.info("response", response);
            log.info("authentication", authentication);
        }).and()
            .anonymous().authenticationFilter(new CustomAnonymousAuthenticationFilter(UUID.randomUUID().toString()));
    }
}
