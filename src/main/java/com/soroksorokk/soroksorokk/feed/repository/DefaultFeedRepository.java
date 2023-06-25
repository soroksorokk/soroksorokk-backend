package com.soroksorokk.soroksorokk.feed.repository;

import com.soroksorokk.soroksorokk.feed.dto.response.GetAllFeedsResponseDto;
import com.soroksorokk.soroksorokk.persist.entities.FeedEntity;
import com.soroksorokk.soroksorokk.persist.repository.FeedJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<GetAllFeedsResponseDto> getAllFeeds() {
        List<FeedEntity> feeds = feedRepository.findAll();
        return feeds.stream().map(f ->
                GetAllFeedsResponseDto.builder()
                        .title(f.getTitle())
                        .text(f.getText())
                        .emotion(f.getEmotion())
                        .isFinish(f.isFinish())
                        .songName(f.getSongName())
                        .user(f.getUser())
                        .bookmarks(f.getBookmarks())
                        .coverImg(f.getCoverImg())
                        .category(f.getCategory())
                        .feedTags(f.getFeedTags())
                        .build()
        ).collect(Collectors.toList());
    }
}
