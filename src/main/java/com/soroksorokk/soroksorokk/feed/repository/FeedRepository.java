package com.soroksorokk.soroksorokk.feed.repository;

import com.soroksorokk.soroksorokk.persist.entities.FeedEntity;

public interface FeedRepository {
    FeedEntity createFeed(FeedEntity feed);
}
