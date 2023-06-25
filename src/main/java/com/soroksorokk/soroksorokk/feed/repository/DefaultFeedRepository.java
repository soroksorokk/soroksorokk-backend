package com.soroksorokk.soroksorokk.feed.repository;

import com.soroksorokk.soroksorokk.persist.entities.FeedEntity;
import com.soroksorokk.soroksorokk.persist.repository.FeedJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultFeedRepository implements FeedRepository { // or JpaFeedRepository
    private final FeedJpaRepository feedRepository;

    public DefaultFeedRepository(FeedJpaRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    @Override
    public FeedEntity createFeed(FeedEntity feed) {
        return feedRepository.save(feed);
    }
}
