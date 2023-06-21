package com.soroksorokk.soroksorokk.auth.service;

import com.soroksorokk.soroksorokk.auth.dto.request.SignupRequestDto;
import com.soroksorokk.soroksorokk.persist.entities.UserEntity;
import com.soroksorokk.soroksorokk.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {
    @InjectMocks
    AuthService authService;

    @Mock
    PasswordEncoder passwordEncoder;

    @Mock
    UserRepository userRepository;

    @Test
        void 회원가입_성공() {
        // given
        SignupRequestDto request = mock(SignupRequestDto.class);
        when(request.email()).thenReturn("email@email.com");
        when(request.password()).thenReturn("password");
        when(request.nickname()).thenReturn("nickname");
        when(request.img()).thenReturn("");
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(userRepository.save(any(UserEntity.class))).thenReturn(UserEntity.builder().build());
        // when
        authService.signup(request);
        //then

        verify(passwordEncoder).encode(request.password());
        verify(userRepository).save(any(UserEntity.class));
        }
}