package com.example.samplemybatis.repository;

import com.example.samplemybatis.entity.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findByPublished(boolean published);

//    @Query("select t from Tutorial t where t.title like %:title%")
    List<Tutorial> findByTitleContaining(String title);

    Tutorial save(Tutorial tutorial);
}
