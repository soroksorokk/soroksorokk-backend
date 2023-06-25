package com.soroksorokk.soroksorokk.feedTags.repository;

import com.soroksorokk.soroksorokk.persist.entities.FeedTagEntity;
import com.soroksorokk.soroksorokk.persist.repository.FeedJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaFeedTagsRepository implements FeedTagsRepository{
    private final FeedJpaRepository feedRepository;

    public JpaFeedTagsRepository(FeedJpaRepository feedRepository) {
        this.feedRepository = feedRepository;
    }


    @Override
    public List<FeedTagEntity> getAllFeedTags() {
        return null;
    }
}
