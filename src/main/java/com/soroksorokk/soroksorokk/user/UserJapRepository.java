package com.soroksorokk.soroksorokk.user;

import com.soroksorokk.soroksorokk.persist.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJapRepository extends JpaRepository<UserEntity, Long>, Userrepository {
    @Override
    boolean existByEmail(String email);

    @Override
    boolean existByNickname(String nickname);
}
