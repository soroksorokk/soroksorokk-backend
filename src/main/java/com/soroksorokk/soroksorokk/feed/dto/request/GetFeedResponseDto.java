package com.soroksorokk.soroksorokk.feed.dto.request;

import com.soroksorokk.soroksorokk.persist.entities.CategoryEntity;
import com.soroksorokk.soroksorokk.persist.entities.FeedEntity;
import com.soroksorokk.soroksorokk.persist.entities.UserEntity;
import com.soroksorokk.soroksorokk.persist.entities.enums.Emotion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetFeedResponseDto {
    private final String title;
    private final String text;
    private final Emotion emotion;
    private final String songName;
    private final String coverImg;
    private final CategoryEntity category;
    private final UserEntity user;

    @Builder
    public GetFeedResponseDto(FeedEntity feed) {
        this.title = feed.getTitle();
        this.text = feed.getText();
        this.emotion = feed.getEmotion();
        this.songName = feed.getSongName();
        this.coverImg = feed.getCoverImg();
        this.category = feed.getCategory();
        this.user = feed.getUser();
    }
}
