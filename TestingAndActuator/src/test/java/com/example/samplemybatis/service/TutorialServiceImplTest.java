package com.example.samplemybatis.service;

import com.example.samplemybatis.entity.Tutorial;
import com.example.samplemybatis.repository.TutorialRepository;
import com.example.samplemybatis.service.Impl.TutorialServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TutorialServiceImplTest {

    @Mock
    private TutorialRepository tutorialRepository;

    @InjectMocks
    private TutorialServiceImpl tutorialService;

    @Test
    void findAll() {
        List<Tutorial> expectedTutorials = Arrays.asList(
                new Tutorial(1L, "title 1", "description 1", true),
                new Tutorial(2L, "title 2", "description 2", false),
                new Tutorial(3L, "title 3", "description 3", true),
                new Tutorial(4L, "title 4", "description 4", true));

        when(tutorialRepository.findAll()).thenReturn(expectedTutorials);

        // call service
        List<Tutorial> actualTutorials = tutorialService.findAll();

        // verify that repo has been called once
        verify(tutorialRepository, times(1)).findAll();

        assertThat(actualTutorials).containsExactlyElementsOf(expectedTutorials);
    }

}
