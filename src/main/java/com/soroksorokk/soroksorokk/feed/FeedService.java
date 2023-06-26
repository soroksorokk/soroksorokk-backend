package com.soroksorokk.soroksorokk.feed;

import com.soroksorokk.soroksorokk.category.service.CategoryService;
import com.soroksorokk.soroksorokk.feed.dto.request.CreateFeedRequestDto;
import com.soroksorokk.soroksorokk.feed.dto.request.GetFeedResponseDto;
import com.soroksorokk.soroksorokk.feed.dto.request.UpdateFeedRequestDto;
import com.soroksorokk.soroksorokk.feed.dto.response.GetAllFeedsResponseDto;
import com.soroksorokk.soroksorokk.feed.exception.NotFeedWriterException;
import com.soroksorokk.soroksorokk.feed.repository.FeedRepository;
import com.soroksorokk.soroksorokk.persist.entities.CategoryEntity;
import com.soroksorokk.soroksorokk.persist.entities.FeedEntity;
import com.soroksorokk.soroksorokk.persist.entities.UserEntity;
import com.soroksorokk.soroksorokk.user.service.GetUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
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
         return feedRepository.getAllFeeds()
                 .stream()
                .map(f -> GetAllFeedsResponseDto.builder()
                        .title(f.getTitle())
                        .text(f.getText())
                        .emotion(f.getEmotion())
                        .songName(f.getSongName())
                        .coverImg(f.getCoverImg())
                        .isFinish(f.isFinish())
                        .user(f.getUser())
                        .feedTags(f.getFeedTags())
                        .category(f.getCategory())
                        .bookmarks(f.getBookmarks())
                        .build()
                ).collect(Collectors.toList());
    }


    // 수정 필요할 듯
    public void updateFeed(Long id, UpdateFeedRequestDto request, String email) {
        FeedEntity dbFeed = feedRepository.getFeedById(id);
        UserEntity dbUser = userService.getUserByEmail(email);
        CategoryEntity dbCategory = categoryService.getCategoryById(request.categoryId());

        if (!dbFeed.validateWriter(dbUser.getId())) {
            throw new NotFeedWriterException();
        }

        dbFeed.updateFeed(request, dbCategory);
    }

    @Transactional(readOnly = true)
    public GetFeedResponseDto getFeed(Long id) {
        FeedEntity dbFeed = feedRepository.getFeedById(id);

        return new GetFeedResponseDto(dbFeed);
    }

    public void deleteFeedById(Long id) {
        feedRepository.deleteFeedById(id);
    }
}
