package com.soroksorokk.soroksorokk.persist.entities;

import com.soroksorokk.soroksorokk.persist.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "user_tag")
public class UserTagEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne(optional = false)
    private UserEntity user;

    @Builder
    public UserTagEntity(String name, UserEntity user) {
        this.name = name;
        this.user = user;
    }
}
