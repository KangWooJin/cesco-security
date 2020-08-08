package com.github.bakery.cesco.week01;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .mvcMatchers("/", "/info", "/account**").permitAll()
            .mvcMatchers("/admin").hasRole("ADMIN")
            .anyRequest()
            .authenticated();

        http.formLogin();
        http.httpBasic();
        http.csrf().disable();
    }

    /**
     * TODO 1주차 과제
     * ADMIN / USER Role 각각 InMemory 로 생성하자..!!
     */
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    }


}
