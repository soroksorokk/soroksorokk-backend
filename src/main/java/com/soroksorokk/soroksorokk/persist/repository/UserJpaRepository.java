package com.soroksorokk.soroksorokk.persist.repository;

import com.soroksorokk.soroksorokk.persist.entities.UserEntity;
import com.soroksorokk.soroksorokk.user.repository.UserQueryRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = UserEntity.class, idClass = Long.class)
public interface UserJpaRepository extends JpaRepository<UserEntity, Long>, UserQueryRepository {

}
