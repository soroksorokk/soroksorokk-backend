package com.soroksorokk.soroksorokk.persist.repository;

import com.soroksorokk.soroksorokk.persist.entities.FeedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedJpaRepository extends JpaRepository<FeedEntity, Long> {

    // TODO: query Dsl setting 
    List<FeedEntity> findAll(); 
}
