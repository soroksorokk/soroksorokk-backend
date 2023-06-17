package com.soroksorokk.soroksorokk.persist.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private String emotion; // enum

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
}
