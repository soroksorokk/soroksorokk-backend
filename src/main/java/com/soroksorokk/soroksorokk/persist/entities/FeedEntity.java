package com.soroksorokk.soroksorokk.persist.entities;

import com.soroksorokk.soroksorokk.feed.dto.request.UpdateFeedRequestDto;
import com.soroksorokk.soroksorokk.persist.common.BaseTimeEntity;
import com.soroksorokk.soroksorokk.persist.entities.enums.Emotion;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Entity(name = "feed")
public class FeedEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100, nullable = false, unique = true)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String text;

    @Column(length = 100, nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private Emotion emotion; // enum

    @Column(nullable = false)
    private String songName;

    @Column
    private String coverImg;

    @Column(nullable = false)
    private boolean isFinish;

    @ManyToOne(optional = false)
    private CategoryEntity category;

    @ManyToOne(optional = false)
    private UserEntity user;

    @OneToMany(mappedBy = "feed")
    private Set<CommentEntity> comments;

    @OneToMany(mappedBy = "feed")
    private Set<BookmarkEntity> bookmarks;

    @OneToMany(mappedBy = "feed")
    private Set<FeedTagEntity> feedTags;

    @Builder
    public FeedEntity(String title, String text, Emotion emotion, String songName, String coverImg,
                      boolean isFinish, CategoryEntity category, UserEntity user) {
        this.title = title;
        this.text = text;
        this.emotion = emotion;
        this.songName = songName;
        this.coverImg = coverImg;
        this.isFinish = isFinish;
        this.category = category;
        this.user = user;
    }

    public void updateFeed(UpdateFeedRequestDto request, CategoryEntity category) {
        this.title = request.title();
        this.text = request.text();
        this.emotion = request.emotion();
        this.songName = request.songName();
        this.coverImg = request.coverImg();
        this.isFinish = request.isFinish();
        this.category = category;
    }

    public boolean validateWriter(long userId) {
        return Objects.equals(this.user.getId(), id);
    }
}
