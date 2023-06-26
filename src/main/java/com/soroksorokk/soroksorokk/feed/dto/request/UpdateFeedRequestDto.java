package com.soroksorokk.soroksorokk.feed.dto.request;

import com.soroksorokk.soroksorokk.persist.entities.enums.Emotion;

public record UpdateFeedRequestDto(String title, String text, Emotion emotion, String songName, String coverImg,
                                   boolean isFinish, Long categoryId) {
}