package com.soroksorokk.soroksorokk.feed.repository;

import com.soroksorokk.soroksorokk.category.repository.CategoryRepository;
import com.soroksorokk.soroksorokk.common.RepositoryTest;
import com.soroksorokk.soroksorokk.feed.exception.FeedNotFoundException;
import com.soroksorokk.soroksorokk.persist.entities.CategoryEntity;
import com.soroksorokk.soroksorokk.persist.entities.FeedEntity;
import com.soroksorokk.soroksorokk.persist.entities.UserEntity;
import com.soroksorokk.soroksorokk.persist.entities.enums.Emotion;
import com.soroksorokk.soroksorokk.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;

@RepositoryTest
class DefaultFeedRepositoryTest {
    public static final String NICKNAME = "nickname";
    public static final String EMAIL = "email@email.com";
    public static final String PASSWORD = "password";
    public static final String CATEGORY_NAME = "category";
    @Autowired
    FeedRepository feedRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Transactional
    @Test
    void createFeed() {
        // given
        UserEntity user = UserEntity.builder()
                .nickname(NICKNAME)
                .email(EMAIL)
                .password(PASSWORD)
                .build();
        userRepository.save(user);

        CategoryEntity category = CategoryEntity.builder()
                .name(CATEGORY_NAME)
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

        //then
        assertThat(feed).isNotNull();
    }

    @Transactional
    @Test
    void deleteFeedById() {
        // given
        // when
        feedRepository.deleteFeedById(1L);

        //then
        assertThatThrownBy(() -> feedRepository.getFeedById(1L))
                .isInstanceOf(FeedNotFoundException.class)
                .hasMessage(FeedNotFoundException.error.getMsg());

    }

    @Transactional
    @Test
        void getFeedById() {
        // given


        // when
        FeedEntity dbFeed = feedRepository.getFeedById(2L);
        //then
        assertThat(dbFeed).isNotNull();
        }

}