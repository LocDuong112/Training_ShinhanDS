package com.example.samplemybatis.repository;

import com.example.samplemybatis.entity.Tutorial;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class TutorialRepositoryTest {

    @Autowired
    private TutorialRepository tutorialRepository;

    private List<Tutorial> listTestingValue = new ArrayList<>();

    @BeforeEach
    void setUp() {
        listTestingValue = Arrays.asList(
                new Tutorial(1L, "title for testing 1", "description for testing 1", true),
                new Tutorial(2L, "title for testing 2", "description for testing 2", true),
                new Tutorial(3L, "title for testing 3", "description for testing 3", false),
                new Tutorial(4L, "title for testing 4", "description for testing 4", false));

        for (Tutorial tutorial: listTestingValue) {
            Tutorial savedTutorial = tutorialRepository.save(tutorial);

            // verify the returned obj is not null
            assertNotNull(savedTutorial);

            // verify the saved obj is the same as the input obj
            assertEquals(tutorial.getDescription(), savedTutorial.getDescription());
            assertEquals(tutorial.getTitle(), savedTutorial.getTitle());

        }
    }

    @AfterEach
    void deleteAllTestingCase() {
        for (Tutorial tutorial: listTestingValue) {
            tutorialRepository.findById(tutorial.getId());
            tutorialRepository.deleteById(tutorial.getId());
        }

        // test all deleted id
        boolean present = false;
        for (Tutorial tutorial: listTestingValue) {
            assertEquals(present, tutorialRepository.findById(tutorial.getId()).isPresent());
        }
    }

    @Test
    void findByTitleContaining() {
        String testingTitle = "title for testing";

        List<Tutorial> expectedTutorials = listTestingValue;

        List<Tutorial> actualTutorials = tutorialRepository.findByTitleContaining(testingTitle);

        // verify expecting result
        for (int idx=0; idx<actualTutorials.size(); idx++) {
            assertEquals(actualTutorials.get(idx).getTitle(), expectedTutorials.get(idx).getTitle());
            assertEquals(actualTutorials.get(idx).getDescription(), expectedTutorials.get(idx).getDescription());
        }
    }

    @Test
    void findByPublished() {
        boolean testingPublished = true;

        List<Tutorial> expectedTutorials = Arrays.asList(
                new Tutorial(1L, "title for testing 1", "description for testing 1", true),
                new Tutorial(2L, "title for testing 2", "description for testing 2", true));

        List<Tutorial> actualTutorials = tutorialRepository.findByPublished(testingPublished);

        // verify expecting result
        for (int idx=0; idx<actualTutorials.size(); idx++) {
            assertEquals(actualTutorials.get(idx).getTitle(), expectedTutorials.get(idx).getTitle());
            assertEquals(actualTutorials.get(idx).getDescription(), expectedTutorials.get(idx).getDescription());
        }
    }
}
