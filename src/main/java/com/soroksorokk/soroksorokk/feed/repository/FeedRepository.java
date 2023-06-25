package com.soroksorokk.soroksorokk.feed.repository;

import com.soroksorokk.soroksorokk.feed.dto.response.GetAllFeedsResponseDto;
import com.soroksorokk.soroksorokk.persist.entities.FeedEntity;

import java.util.List;

public interface FeedRepository {
    FeedEntity createFeed(FeedEntity feed);

    List<GetAllFeedsResponseDto> getAllFeeds();
}
