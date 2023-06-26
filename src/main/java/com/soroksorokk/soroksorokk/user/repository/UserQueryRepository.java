package com.soroksorokk.soroksorokk.user.repository;

import com.soroksorokk.soroksorokk.persist.entities.UserEntity;

public interface UserQueryRepository {
    boolean existsByEmail(String email);

    boolean existsByNickname(String nickname);

    UserEntity findByEmail(String email);
}
