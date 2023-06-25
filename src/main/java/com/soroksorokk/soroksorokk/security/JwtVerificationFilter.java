package com.soroksorokk.soroksorokk.security;

import com.soroksorokk.soroksorokk.jwt.TokenProvider;
import com.soroksorokk.soroksorokk.jwt.exception.InvalidJwtTokenException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtVerificationFilter extends OncePerRequestFilter {
    private final TokenProvider tokenProvider;

    public JwtVerificationFilter(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        if (request.getHeader(HttpHeaders.AUTHORIZATION) != null) {
            String token = tokenProvider.getToken(request);

            boolean result = tokenProvider.validateToken(token);

            if (!result) {
                throw new InvalidJwtTokenException();
            }

            Authentication authentication = tokenProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);

        }

        doFilter(request, response, filterChain);
    }
}
