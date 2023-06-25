package com.soroksorokk.soroksorokk.feed.repository;

import com.soroksorokk.soroksorokk.common.RepositoryTest;
import com.soroksorokk.soroksorokk.persist.entities.FeedEntity;
import com.soroksorokk.soroksorokk.persist.entities.UserEntity;
import com.soroksorokk.soroksorokk.persist.entities.enums.Emotion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RepositoryTest
class DefaultFeedRepositoryTest {
    @Autowired
    FeedRepository feedRepository;

    @Test
        void createFeed() {
        // given
        UserEntity dbUser = UserEntity.builder()
                .nickname("nickname")
                .email("email@email.com")
                .password("password")
                .build();

        FeedEntity newFeed = FeedEntity.builder()
                .title("request.title()")
                .text("request.text()")
                .songName("request.songName()")
                .coverImg("request.coverImg()")
                .emotion(Emotion.ANGRY)
                .category("request.category()")
                .isFinish(true)
                .user(dbUser)
                .build();
        // when
        FeedEntity feed = feedRepository.createFeed(newFeed);
        System.out.println(feed);
        //then
        assertThat(feed).isNotNull();
        }
}