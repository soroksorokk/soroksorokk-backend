package com.soroksorokk.soroksorokk.userTag.repository;

import com.soroksorokk.soroksorokk.persist.entities.UserTagEntity;
import com.soroksorokk.soroksorokk.persist.repository.UserTagJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DefaultUserTagRepository  implements UserTagRepository {

    private final UserTagJpaRepository userRepository;

    public DefaultUserTagRepository(UserTagJpaRepository userTagJpaRepository) {
        this.userRepository = userTagJpaRepository;
    }

    @Override
    public void createUserTag(UserTagEntity entity) {
        userRepository.save(entity);
    }

    @Override
    public List<UserTagEntity> getAllUserTagsById(Long userId) {
        return userRepository.getAllUserTagsById(userId);
    }

    @Override
    public void modifyUserTagByUserIdAndId(Long userId, Long id, String modifyName) {
        userRepository.modifyUserTagByUserIdAndId(userId, id, modifyName);
    }

    @Override
    public void deleteUserTagByUserIdAndId(Long userId, Long id) {
        userRepository.deleteUserTagByUserIdAndId(userId, id);
    }
}
