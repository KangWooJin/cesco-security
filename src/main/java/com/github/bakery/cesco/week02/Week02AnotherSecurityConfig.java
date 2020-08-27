package com.github.bakery.cesco.week02;

import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
 * TODO : 2주차 과제 authenticationManager
 *  /week02/** 로 시작하는 path의 경우
 *  Custom AuthenticationProvider를 생성하여 Week02UserDetailsService의 유저를 생성하기
 */
@Order(10000 - 25)
@EnableWebSecurity
public class Week02AnotherSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/week02/second")
            .authorizeRequests()
            .antMatchers("/week02/second").permitAll()
            .and()
            .csrf().disable();
    }
}
