package com.example.samplemybatis.repository;

import com.example.samplemybatis.entity.Tutorial;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class TutorialRepositoryTest {

    @Autowired
    private TutorialRepository tutorialRepository;

    @Test
    void save() {
        Tutorial tutorialNew = new Tutorial();
        tutorialNew.setDescription("description 1");
        tutorialNew.setPublished(true);
        tutorialNew.setTitle("title 1");

        Tutorial tutorial = tutorialRepository.save(tutorialNew);

        assertNotNull(tutorial);
    }
}
