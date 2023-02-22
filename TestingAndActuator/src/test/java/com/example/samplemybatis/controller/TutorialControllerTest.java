package com.example.samplemybatis.controller;

import com.example.samplemybatis.entity.Tutorial;
import com.example.samplemybatis.service.SampleTutorialService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(TutorialController.class)
public class TutorialControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SampleTutorialService tutorialService;


    @Test
    void getAllTutorials() throws Exception {
        // Define the mock tutorials
        List<Tutorial> listMockTutorials = Arrays.asList(
                new Tutorial(1L, "title 1", "description 1", true),
                new Tutorial(2L, "title 2", "description 2", false),
                new Tutorial(3L, "title 3", "description 3", true),
                new Tutorial(4L, "title 4", "description 4", true));

        when(tutorialService.findAll()).thenReturn(listMockTutorials);

        mockMvc.perform(get("/api/tutorials"))
                .andExpect(status().isOk())

                // "$" is kind of a response body
                .andExpect(jsonPath("$", hasSize(4)))

                // content() to retrieve body response and make it to String
                // json() to make listMockTutorials becomes json type
                .andExpect(content().json(new ObjectMapper().writeValueAsString(listMockTutorials)));
    }

    @Test
    void createTutorial() throws Exception {
        // Define the mock tutorials
        Tutorial tutorial = new Tutorial(1L, "title 1", "description 1", true);

        // set up for mock
        when(tutorialService.save(any(Tutorial.class))).thenReturn(tutorial);

        mockMvc.perform(post("/api/tutorials")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(tutorial)))
                .andExpect(status().isCreated());

        verify(tutorialService, times(1)).save(any(Tutorial.class));
    }

}
