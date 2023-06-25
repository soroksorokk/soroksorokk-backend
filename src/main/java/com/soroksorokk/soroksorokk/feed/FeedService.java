package com.soroksorokk.soroksorokk.feed;

import com.soroksorokk.soroksorokk.feed.dto.request.CreateFeedRequestDto;
import com.soroksorokk.soroksorokk.feed.repository.FeedRepository;
import com.soroksorokk.soroksorokk.persist.entities.FeedEntity;
import com.soroksorokk.soroksorokk.persist.entities.UserEntity;
import com.soroksorokk.soroksorokk.user.service.GetUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FeedService {
    private final FeedRepository feedRepository;
    private final GetUserService userService;

    public FeedService(FeedRepository feedRepository, GetUserService userService) {
        this.feedRepository = feedRepository;
        this.userService = userService;
    }

    @Transactional
    void createFeed(CreateFeedRequestDto request, String email) {
        // title 중복
        UserEntity dbUser = userService.getUserByEmail(email);

        FeedEntity newFeed = FeedEntity.builder()
                .title(request.title())
                .text(request.text())
                .songName(request.songName())
                .coverImg(request.coverImg())
                .emotion(request.emotion())
                .category(request.category())
                .isFinish(request.isFinish())
                .user(dbUser)
                .build();

        feedRepository.createFeed(newFeed);
    }
}
