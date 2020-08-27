package com.github.bakery.cesco.week02;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

public class WAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
    private final Week02UserDetailsService week02UserDetailsService = new Week02UserDetailsService();

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        return week02UserDetailsService.loadUserByUsername(username);
    }
}
