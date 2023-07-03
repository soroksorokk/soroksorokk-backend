package com.soroksorokk.soroksorokk.userTag.repository;

import com.soroksorokk.soroksorokk.persist.entities.UserTagEntity;

import java.util.List;

public interface UserTagQueryRepository {
    List<UserTagEntity> getAllUserTagsById(Long userId);
    void modifyUserTagByUserIdAndId(Long userId, Long id, String modifyName);
    void deleteUserTagByUserIdAndId(Long userId, Long id);
}
