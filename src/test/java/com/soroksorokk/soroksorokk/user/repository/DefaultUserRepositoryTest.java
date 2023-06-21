package com.soroksorokk.soroksorokk.user.repository;

import com.soroksorokk.soroksorokk.common.RepositoryTest;
import com.soroksorokk.soroksorokk.persist.entities.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;

@RepositoryTest
class DefaultUserRepositoryTest {
    @Autowired
    DefaultUserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Test
    void save() {
        // given
        UserEntity newUser = UserEntity.builder()
                .nickname("nickname")
                .email("email@email.com")
                .password(passwordEncoder.encode("password"))
                .img("")
                .build();

        // when
        userRepository.save(newUser);
        //then
        assertThat(userRepository.existsByEmail(newUser.getEmail())).isTrue();
    }
}