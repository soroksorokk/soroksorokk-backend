package com.soroksorokk.soroksorokk.user.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.soroksorokk.soroksorokk.persist.entities.QUserEntity;
import com.soroksorokk.soroksorokk.persist.entities.UserEntity;


public class UserQueryRepositoryImpl implements UserQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public UserQueryRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public boolean existsByEmail(String email) {
        QUserEntity user = QUserEntity.userEntity;
        UserEntity dbUser = jpaQueryFactory.select(user)
                .from(user)
                .where(user.email.eq(email))
                .fetchOne();

        return dbUser != null;
    }

    @Override
    public boolean existsByNickname(String nickname) {
        QUserEntity user = QUserEntity.userEntity;
        UserEntity dbUser = jpaQueryFactory.select(user)
                .from(user)
                .where(user.nickname.eq(nickname))
                .fetchOne();

        return dbUser != null;
    }

    @Override
    public UserEntity findByEmail(String email) {
        QUserEntity user = QUserEntity.userEntity;
        return jpaQueryFactory.select(user)
                .from(user)
                .where(user.email.eq(email))
                .fetchOne();
    }
}
