package com.example.samplemybatis.service.Impl;

import com.example.samplemybatis.entity.Tutorial;
import com.example.samplemybatis.repository.MyBatisTutorialRepository;
import com.example.samplemybatis.repository.TutorialRepository;
import com.example.samplemybatis.service.SampleTutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class TutorialServiceImpl implements SampleTutorialService {
    @Autowired
    private TutorialRepository tutorialRepository;

    @Resource
    private MyBatisTutorialRepository myBatisTutorialRepository;

    @Override
    public List<Tutorial> findAll() {
        return tutorialRepository.findAll();
    }

    @Override
    public List<Tutorial> findByTitleContaining(String title) {
        return tutorialRepository.findByTitleContaining(title);
    }

    @Override
    public Optional<Tutorial> findById(Long id) {
        return tutorialRepository.findById(id);
    }

    @Override
    public void deletedById(Long id) {
        tutorialRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        tutorialRepository.deleteAll();
    }

    @Override
    public List<Tutorial> findByPublished(boolean published) {
        return tutorialRepository.findByPublished(published);
    }

    @Override
    public Tutorial save(Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }

    @Override
    public int countMyBatis() {
        return myBatisTutorialRepository.count();
    }
}
