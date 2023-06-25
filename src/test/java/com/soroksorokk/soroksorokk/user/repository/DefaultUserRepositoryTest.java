package com.soroksorokk.soroksorokk.user.repository;

import com.soroksorokk.soroksorokk.persist.entities.UserEntity;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatObject;

@ActiveProfiles("test")
@SpringBootTest
@Testcontainers
class DefaultUserRepositoryTest {
    private static final MySQLContainer mySQLContainer = new MySQLContainer(DockerImageName.parse("mysql:8.0"))
            .withDatabaseName("test")
            .withUsername("user")
            .withPassword("password");

    static {
        mySQLContainer.start();
    }

    @Autowired
    DefaultUserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    // TODO: Database 내의 초기 데이터를 어떻게 구성할 것인가?
    @Test
    void saveAndExistsByEmail() {
        // given
        // when
        UserEntity newUser = UserEntity.builder()
                .nickname("nickname")
                .email("email@email.com")
                .password(passwordEncoder.encode("password"))
                .build();
        // when
        UserEntity result = userRepository.save(newUser);
        //then
        assertThat(result.getId()).isNotNull();
        //then
        assertThat(userRepository.existsByEmail(newUser.getEmail())).isTrue();
    }

    @Test
    void saveAndExistsByNickname() {
        // given
        UserEntity newUser = UserEntity.builder()
                .nickname("nickname2")
                .email("email2@email.com")
                .password(passwordEncoder.encode("password"))
                .build();
        // when
        UserEntity result = userRepository.save(newUser);
        //then
        assertThat(userRepository.existsByNickname(newUser.getNickname())).isTrue();
    }
}