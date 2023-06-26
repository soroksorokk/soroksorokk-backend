package com.soroksorokk.soroksorokk.feed.dto.response;

import com.soroksorokk.soroksorokk.persist.entities.BookmarkEntity;
import com.soroksorokk.soroksorokk.persist.entities.CategoryEntity;
import com.soroksorokk.soroksorokk.persist.entities.FeedTagEntity;
import com.soroksorokk.soroksorokk.persist.entities.UserEntity;
import com.soroksorokk.soroksorokk.persist.entities.enums.Emotion;
import com.soroksorokk.soroksorokk.user.dto.response.GetUserResponseDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Set;

@Getter
public class GetAllFeedsResponseDto {
    private final String title;
    private final String text;
    private final Emotion emotion;
    private final String songName;
    private final String coverImg;
    private final boolean isFinish;
    private final int bookmarkCnt;
    private final CategoryEntity category;
    private final GetUserResponseDto user;
    private final Set<FeedTagEntity> feedTags;


    @Builder
    public GetAllFeedsResponseDto(String title, String text, Emotion emotion, String songName, String coverImg,
                                  boolean isFinish, CategoryEntity category, UserEntity user,
                                  Set<BookmarkEntity> bookmarks,
                                  Set<FeedTagEntity> feedTags) {
        this.title = title;
        this.text = text;
        this.emotion = emotion;
        this.songName = songName;
        this.coverImg = coverImg;
        this.isFinish = isFinish;
        this.category = category;
        this.user = new GetUserResponseDto(user.getId(), user.getNickname(), user.getEmail(), user.getImg());
        this.bookmarkCnt = bookmarks.size();
        this.feedTags = feedTags;
    }
}
