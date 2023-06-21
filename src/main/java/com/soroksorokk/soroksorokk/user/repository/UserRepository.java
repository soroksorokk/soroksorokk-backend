package com.soroksorokk.soroksorokk.user.repository;

import com.soroksorokk.soroksorokk.persist.entities.UserEntity;

public interface UserRepository {
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);
    Object save(UserEntity user);
}
