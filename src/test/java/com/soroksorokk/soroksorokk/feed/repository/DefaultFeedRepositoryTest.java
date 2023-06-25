package com.soroksorokk.soroksorokk.feed.repository;

import com.soroksorokk.soroksorokk.category.repository.CategoryRepository;
import com.soroksorokk.soroksorokk.common.RepositoryTest;
import com.soroksorokk.soroksorokk.persist.entities.CategoryEntity;
import com.soroksorokk.soroksorokk.persist.entities.FeedEntity;
import com.soroksorokk.soroksorokk.persist.entities.UserEntity;
import com.soroksorokk.soroksorokk.persist.entities.enums.Emotion;
import com.soroksorokk.soroksorokk.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RepositoryTest
class DefaultFeedRepositoryTest {
    @Autowired
    FeedRepository feedRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
        void createFeed() {
        // given
        UserEntity user = UserEntity.builder()
                .nickname("nickname")
                .email("email@email.com")
                .password("password")
                .build();
        userRepository.save(user);

        CategoryEntity category = CategoryEntity.builder()
                .name("category")
                .build();
        categoryRepository.createCategory(category);

        FeedEntity newFeed = FeedEntity.builder()
                .title("request.title()")
                .text("request.text()")
                .songName("request.songName()")
                .coverImg("request.coverImg()")
                .emotion(Emotion.ANGRY)
                .isFinish(true)
                .category(category)
                .user(user)
                .build();
        // when
        FeedEntity feed = feedRepository.createFeed(newFeed);

        System.out.println(feed);
        //then
        assertThat(feed).isNotNull();
        }
}