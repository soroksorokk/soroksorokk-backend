package com.soroksorokk.soroksorokk.auth.service;

import com.soroksorokk.soroksorokk.auth.dto.request.LoginRequestDto;
import com.soroksorokk.soroksorokk.auth.dto.request.SignupRequestDto;
import com.soroksorokk.soroksorokk.auth.dto.response.LoginResponseDto;
import com.soroksorokk.soroksorokk.persist.entities.UserEntity;
import com.soroksorokk.soroksorokk.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements AuthUseCase {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public AuthService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public LoginResponseDto login(LoginRequestDto request) {
        return null;
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
