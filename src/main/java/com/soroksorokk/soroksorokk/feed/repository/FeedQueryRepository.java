package com.soroksorokk.soroksorokk.feed.repository;

import com.soroksorokk.soroksorokk.feed.dto.request.GetFeedResponseDto;
import com.soroksorokk.soroksorokk.feed.dto.response.GetAllFeedsResponseDto;
import com.soroksorokk.soroksorokk.persist.entities.FeedEntity;

import java.util.List;

public interface FeedQueryRepository {
    List<FeedEntity> getAllFeeds();

    FeedEntity getFeedById(Long id);

    void softDeleteById(Long id);
}
