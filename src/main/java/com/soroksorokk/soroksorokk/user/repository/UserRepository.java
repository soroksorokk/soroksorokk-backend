package com.soroksorokk.soroksorokk.user.repository;

import com.soroksorokk.soroksorokk.persist.entities.UserEntity;

public interface UserRepository {
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);
    // TODO: UserEntity를 입력받아 UserEntitiy를 반환하고 있다. Service계층, 코드베이스에서 사용될 도메인객체가 있으면 어떨까?
    UserEntity save(UserEntity user);
}
