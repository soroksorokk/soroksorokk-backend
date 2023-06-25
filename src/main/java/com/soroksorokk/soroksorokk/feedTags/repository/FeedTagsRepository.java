package com.soroksorokk.soroksorokk.feedTags.repository;

import com.soroksorokk.soroksorokk.persist.entities.FeedTagEntity;

import java.util.List;

public interface FeedTagsRepository {
    List<FeedTagEntity> getAllFeedTags();
}
