package com.github.bakery.cesco.week05;

import java.time.OffsetDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

/**
 * Hint createAuthentication override
 */
public class CustomAnonymousAuthenticationFilter extends AnonymousAuthenticationFilter {

    private String key;

    public CustomAnonymousAuthenticationFilter(String key) {
        super(key);
        this.key = key;
    }

    public CustomAnonymousAuthenticationFilter(String key, Object principal,
                                               List<GrantedAuthority> authorities) {
        super(key, principal, authorities);
    }

    @Override
    protected Authentication createAuthentication(HttpServletRequest request) {
        CustomAnonymousAuthenticationToken customAnonymousAuthenticationToken = new CustomAnonymousAuthenticationToken(OffsetDateTime.now(), key, getPrincipal(), getAuthorities());
        customAnonymousAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        return customAnonymousAuthenticationToken;
    }
}
