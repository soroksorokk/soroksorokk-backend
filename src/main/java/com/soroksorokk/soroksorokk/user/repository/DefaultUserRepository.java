package com.soroksorokk.soroksorokk.user.repository;

import com.soroksorokk.soroksorokk.persist.entities.UserEntity;
import com.soroksorokk.soroksorokk.persist.repository.UserJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultUserRepository implements UserRepository {
    private final UserJpaRepository userRepository;

    public DefaultUserRepository(UserJpaRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByNickname(String nickname) {
        return userRepository.existsByNickname(nickname);
    }

    @Override
    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
