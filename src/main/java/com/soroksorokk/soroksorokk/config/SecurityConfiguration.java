package com.soroksorokk.soroksorokk.config;

import com.soroksorokk.soroksorokk.jwt.TokenProvider;
import com.soroksorokk.soroksorokk.security.JwtUserDetailsService;
import com.soroksorokk.soroksorokk.security.JwtVerificationFilter;
import com.soroksorokk.soroksorokk.user.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    private final TokenProvider tokenProvider;
    private final UserRepository userRepository;

    private final UserDetailsService userDetailsService;

    public SecurityConfiguration(TokenProvider tokenProvider, UserRepository userRepository,
                                 UserDetailsService userDetailsService) {
        this.tokenProvider = tokenProvider;
        this.userRepository = userRepository;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtVerificationFilter jwtVerificationFilter() {
        return new JwtVerificationFilter(tokenProvider);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/h2-console/**");
                    auth.requestMatchers(HttpMethod.GET, "/v3/api-docs/**", "/swagger-ui/**", "/swagger-resources/**").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/feeds").permitAll();
                    auth.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll();
                    auth.requestMatchers("/auth/**").permitAll();
                    auth.anyRequest().authenticated();
                })
                .headers(header -> header.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .addFilterBefore(jwtVerificationFilter(), UsernamePasswordAuthenticationFilter.class)
                .userDetailsService(userDetailsService)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }

}
