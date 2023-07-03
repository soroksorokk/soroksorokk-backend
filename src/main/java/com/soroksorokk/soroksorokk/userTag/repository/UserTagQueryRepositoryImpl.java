package com.soroksorokk.soroksorokk.userTag.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.soroksorokk.soroksorokk.persist.entities.QUserTagEntity;
import com.soroksorokk.soroksorokk.persist.entities.UserTagEntity;

import java.time.LocalDateTime;
import java.util.List;

public class UserTagQueryRepositoryImpl implements UserTagQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public UserTagQueryRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<UserTagEntity> getAllUserTagsById(Long userId) {
        QUserTagEntity userTag = QUserTagEntity.userTagEntity;

        return jpaQueryFactory.select(userTag)
                .from(userTag)
                .where(userTag.user.id.eq(userId))
                .where(userTag.deletedAt.isNotNull())
                .fetch();
    }

    @Override
    public void modifyUserTagByUserIdAndId(Long userId, Long id, String modifyName) {
        QUserTagEntity userTag = QUserTagEntity.userTagEntity;

        jpaQueryFactory.update(userTag)
                .set(userTag.name, modifyName)
                .set(userTag.updatedAt, LocalDateTime.now())
                .where(userTag.user.id.eq(userId))
                .where(userTag.id.eq(id))
                .execute();
    }

    @Override
    public void deleteUserTagByUserIdAndId(Long userId, Long id) {
        QUserTagEntity userTag = QUserTagEntity.userTagEntity;

        jpaQueryFactory.update(userTag)
                .set(userTag.deletedAt, LocalDateTime.now())
                .where(userTag.user.id.eq(userId))
                .where(userTag.id.eq(id))
                .execute();
    }
}
