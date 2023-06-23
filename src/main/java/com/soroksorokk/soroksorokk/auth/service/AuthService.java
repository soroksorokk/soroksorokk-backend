package com.soroksorokk.soroksorokk.auth.service;

import com.soroksorokk.soroksorokk.auth.dto.request.LoginRequestDto;
import com.soroksorokk.soroksorokk.auth.dto.request.SignupRequestDto;
import com.soroksorokk.soroksorokk.auth.dto.response.LoginResponseDto;
import com.soroksorokk.soroksorokk.auth.exception.InvalidEmailOrPasswordException;
import com.soroksorokk.soroksorokk.jwt.JwtToken;
import com.soroksorokk.soroksorokk.jwt.TokenProvider;
import com.soroksorokk.soroksorokk.persist.entities.UserEntity;
import com.soroksorokk.soroksorokk.user.repository.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements AuthUseCase {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final TokenProvider tokenProvider;

    public AuthService(PasswordEncoder passwordEncoder, UserRepository userRepository, TokenProvider tokenProvider) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.tokenProvider = tokenProvider;
    }

    @Override
    public LoginResponseDto login(LoginRequestDto request) {
        UserEntity dbUser = userRepository.findByEmail(request.email());
        boolean matches = passwordEncoder.matches(request.password(), dbUser.getPassword());

        if (!matches) {
            throw new InvalidEmailOrPasswordException();
        }

        JwtToken jwtToken = new JwtToken(tokenProvider.createToken(dbUser.getEmail()));

        return new LoginResponseDto(jwtToken);
    }

    @Override
    public void signup(SignupRequestDto request) {
        String encodedPassword = passwordEncoder.encode(request.password());
        UserEntity newUser = UserEntity.builder()
                .email(request.email())
                .password(encodedPassword)
                .nickname(request.nickname())
                .img(request.img())
                .build();

        userRepository.save(newUser);
    }
}
