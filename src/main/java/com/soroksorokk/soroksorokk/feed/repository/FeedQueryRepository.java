package com.soroksorokk.soroksorokk.feed.repository;

import com.soroksorokk.soroksorokk.feed.dto.response.GetAllFeedsResponseDto;

import java.util.List;

public interface FeedQueryRepository {
    List<GetAllFeedsResponseDto> getAllFeeds();
}
