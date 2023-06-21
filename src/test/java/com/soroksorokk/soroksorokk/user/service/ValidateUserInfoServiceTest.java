package com.soroksorokk.soroksorokk.user.service;

import com.soroksorokk.soroksorokk.auth.exception.EmailInUseException;
import com.soroksorokk.soroksorokk.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ValidateUserInfoServiceTest {
    @Mock
    UserRepository userRepository;

    @InjectMocks
    ValidateUserInfoService validateUserInfoService;

    @Test
    void 이메일_중복_검사_OK() {
        // given
        when(userRepository.existsByEmail(anyString())).thenReturn(false);
        // when
        var ret = validateUserInfoService.existsByEmail("email@email.com");
        //then
        verify(userRepository).existsByEmail(anyString());
        assertThat(ret).isFalse();
    }

    @Test
    void 이메일_중복_검사_400() {
        // given
        when(userRepository.existsByEmail(anyString())).thenReturn(true);
        // when
        //then
        assertThatThrownBy(() -> validateUserInfoService.existsByEmail(anyString()))
                .isInstanceOf(EmailInUseException.class)
                .hasMessage(EmailInUseException.error.getMsg());
    }
}
