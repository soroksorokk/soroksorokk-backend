package com.soroksorokk.soroksorokk.feed.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.soroksorokk.soroksorokk.feed.dto.response.GetAllFeedsResponseDto;
import com.soroksorokk.soroksorokk.persist.entities.*;

import java.util.List;
import java.util.stream.Collectors;

public class FeedQueryRepositoryImpl implements FeedQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public FeedQueryRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<GetAllFeedsResponseDto> getAllFeeds() {
        QFeedEntity feed = QFeedEntity.feedEntity;
        QUserEntity user = QUserEntity.userEntity;
        QBookmarkEntity bookmark = QBookmarkEntity.bookmarkEntity;
        QCategoryEntity category = QCategoryEntity.categoryEntity;
        QFeedTagEntity feedTag = QFeedTagEntity.feedTagEntity;

        List<FeedEntity> feeds = jpaQueryFactory.select(feed)
                .from(feed)
                .join(user)
                .on(feed.user.id.eq(user.id))
                .join(category)
                .on(feed.category.id.eq(category.id))
                .fetch();

        return feeds.stream()
                .map(f -> GetAllFeedsResponseDto.builder()
                        .title(f.getTitle())
                        .text(f.getText())
                        .songName(f.getSongName())
                        .coverImg(f.getCoverImg())
                        .emotion(f.getEmotion())
                        .isFinish(f.isFinish())
                        .bookmarks(List.of())
                        .feedTags(List.of())
                        .category(f.getCategory())
                        .user(f.getUser())
                        .build())
                .collect(Collectors.toList());
    }
}
