package com.soroksorokk.soroksorokk.persist.repository;

import com.soroksorokk.soroksorokk.feed.repository.FeedQueryRepository;
import com.soroksorokk.soroksorokk.feed.repository.FeedRepository;
import com.soroksorokk.soroksorokk.persist.entities.FeedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface FeedJpaRepository extends JpaRepository<FeedEntity, Long>, FeedQueryRepository {

}
