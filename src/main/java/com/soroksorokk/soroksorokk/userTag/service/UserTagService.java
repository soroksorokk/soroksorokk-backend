package com.soroksorokk.soroksorokk.userTag.service;

import com.soroksorokk.soroksorokk.persist.entities.UserEntity;
import com.soroksorokk.soroksorokk.persist.entities.UserTagEntity;
import com.soroksorokk.soroksorokk.user.repository.UserRepository;
import com.soroksorokk.soroksorokk.userTag.dto.request.CreateUserTagRequestDto;
import com.soroksorokk.soroksorokk.userTag.dto.request.ModifyUserTagRequestDto;
import com.soroksorokk.soroksorokk.userTag.repository.UserTagRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserTagService {

    private final UserTagRepository userTagRepository;
    private final UserRepository userRepository;

    public UserTagService(UserTagRepository userTagRepository, UserRepository userRepository) {
        this.userTagRepository = userTagRepository;
        this.userRepository = userRepository;
    }

    public void createUserTag(String email, CreateUserTagRequestDto request) {
        UserEntity dbUser = userRepository.findByEmail(email);

        UserTagEntity newUserTag = UserTagEntity.builder()
                .name(request.getName())
                .user(dbUser)
                .build();

        userTagRepository.createUserTag(newUserTag);
    }

    public void modifyUserTag(String email, Long id, ModifyUserTagRequestDto request) {
        UserEntity dbUser = userRepository.findByEmail(email);

        userTagRepository.modifyUserTagByUserIdAndId(dbUser.getId(), id, request.getName());
    }

    @Transactional(readOnly = true)
    public void getAllUserTags(String email) {
        UserEntity dbUser = userRepository.findByEmail(email);

        userTagRepository.getAllUserTagsById(dbUser.getId());
    }

    public void deleteUserTag(String email, Long id) {
        UserEntity dbUser = userRepository.findByEmail(email);

        userTagRepository.deleteUserTagByUserIdAndId(dbUser.getId(), id);
    }
}
