package com.example.samplemybatis.service;

import com.example.samplemybatis.entity.Tutorial;

import java.util.List;
import java.util.Optional;

public interface SampleTutorialService {
    List<Tutorial> findAll();

    List<Tutorial> findByTitleContaining(String title);

    Optional<Tutorial> findById(Long id);

    void deletedById(Long id);

    List<Tutorial> findByPublished(boolean published);

    Tutorial save(Tutorial tutorial);
}
