package com.soroksorokk.soroksorokk.feed.repository;

import com.soroksorokk.soroksorokk.feed.dto.response.GetAllFeedsResponseDto;
import com.soroksorokk.soroksorokk.persist.entities.FeedEntity;
import com.soroksorokk.soroksorokk.persist.repository.FeedJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DefaultFeedRepository implements FeedRepository {
    private final FeedJpaRepository jpaRepository;

    public DefaultFeedRepository(FeedJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public FeedEntity createFeed(FeedEntity feed) {
        return jpaRepository.save(feed);
    }

    @Override
    public List<GetAllFeedsResponseDto> getAllFeeds() {
        return jpaRepository.getAllFeeds();
    }
}
