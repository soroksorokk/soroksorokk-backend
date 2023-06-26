package com.soroksorokk.soroksorokk.feed.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.soroksorokk.soroksorokk.feed.dto.request.GetFeedResponseDto;
import com.soroksorokk.soroksorokk.feed.dto.response.GetAllFeedsResponseDto;
import com.soroksorokk.soroksorokk.feed.exception.FeedNotFoundException;
import com.soroksorokk.soroksorokk.persist.entities.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FeedQueryRepositoryImpl implements FeedQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public FeedQueryRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<FeedEntity> getAllFeeds() {
        QFeedEntity feed = QFeedEntity.feedEntity;

        return jpaQueryFactory.select(feed)
                .from(feed)
                .join(feed.user)
                .join(feed.category)
                .join(feed.bookmarks).fetchJoin()
                .join(feed.feedTags).fetchJoin()
                .where(feed.isFinish.isTrue())
                .fetch();
    }

    @Override
    public FeedEntity getFeedById(Long id) {
        QFeedEntity feed = QFeedEntity.feedEntity;

        FeedEntity dbFeed = jpaQueryFactory.select(feed)
                .from(feed)
                .join(feed.user)
                .join(feed.category)
                .join(feed.bookmarks).fetchJoin()
                .join(feed.feedTags).fetchJoin()
                .join(feed.comments).fetchJoin()
                .fetchOne();

        if (Objects.isNull(dbFeed)) {
            throw new FeedNotFoundException();
        }

        return dbFeed;
    }

    @Override
    public void softDeleteById(Long id) {
        QFeedEntity feed = QFeedEntity.feedEntity;
        jpaQueryFactory.update(feed)
                .set(feed.deletedAt, LocalDateTime.now())
                .where(feed.id.eq(id))
                .execute();
    }
}
