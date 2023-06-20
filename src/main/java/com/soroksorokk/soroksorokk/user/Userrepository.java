package com.soroksorokk.soroksorokk.user;

import com.soroksorokk.soroksorokk.persist.entities.UserEntity;

public interface Userrepository {
    boolean existByEmail(String email);
    boolean existByNickname(String nickname);
    Object save(UserEntity user);
}
