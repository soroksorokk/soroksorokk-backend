package com.soroksorokk.soroksorokk.feed;

import com.soroksorokk.soroksorokk.category.service.CategoryService;
import com.soroksorokk.soroksorokk.feed.dto.request.CreateFeedRequestDto;
import com.soroksorokk.soroksorokk.feed.dto.response.GetAllFeedsResponseDto;
import com.soroksorokk.soroksorokk.feed.repository.FeedRepository;
import com.soroksorokk.soroksorokk.persist.entities.CategoryEntity;
import com.soroksorokk.soroksorokk.persist.entities.FeedEntity;
import com.soroksorokk.soroksorokk.persist.entities.UserEntity;
import com.soroksorokk.soroksorokk.user.service.GetUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FeedService {
    private final FeedRepository feedRepository;
    private final GetUserService userService;
    private final CategoryService categoryService;

    public FeedService(FeedRepository feedRepository, GetUserService userService, CategoryService categoryService) {
        this.feedRepository = feedRepository;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Transactional
    void createFeed(CreateFeedRequestDto request, String email) {
        // title 중복
        UserEntity dbUser = userService.getUserByEmail(email);
        CategoryEntity dbCategory = categoryService.getCategoryById(request.categoryId());

        FeedEntity newFeed = FeedEntity.builder()
                .title(request.title())
                .text(request.text())
                .songName(request.songName())
                .coverImg(request.coverImg())
                .emotion(request.emotion())
                .isFinish(request.isFinish())
                .category(dbCategory)
                .user(dbUser)
                .build();

        feedRepository.createFeed(newFeed);
    }

    @Transactional(readOnly = true)
    public List<GetAllFeedsResponseDto> getAllFeeds() {
        return feedRepository.getAllFeeds();
    }
}
