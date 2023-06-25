package com.soroksorokk.soroksorokk.persist.entities;

import com.soroksorokk.soroksorokk.persist.entities.enums.Emotion;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "feed")
public class FeedEntity {
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
    private List<CommentEntity> comments;

    @OneToMany(mappedBy = "feed")
    private List<BookmarkEntity> bookmarks;

    @OneToMany(mappedBy = "feed")
    private List<FeedTagEntity> feedTags;

    @Builder
    public FeedEntity(String title, String text, Emotion emotion, String songName, String coverImg,
                      boolean isFinish, String category, UserEntity user) {
        this.title = title;
        this.text = text;
        this.emotion = emotion;
        this.songName = songName;
        this.coverImg = coverImg;
        this.isFinish = isFinish;
        this.category = CategoryEntity.builder().name(category).build();
        this.user = user;
    }
}
