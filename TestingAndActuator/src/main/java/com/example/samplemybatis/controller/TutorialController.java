package com.example.samplemybatis.controller;

import com.example.samplemybatis.entity.Tutorial;
import com.example.samplemybatis.service.SampleTutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class TutorialController {
    @Autowired
    private SampleTutorialService sampleTutorialService;

    @GetMapping("tutorials")
    public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
        try {
            List<Tutorial> tutorials = new ArrayList<>();

            if (title == null) tutorials = sampleTutorialService.findAll();

            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("tutorials")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
        try {
            Tutorial tmpTutorial = new Tutorial();

            tmpTutorial.setTitle(tutorial.getTitle());
            tmpTutorial.setDescription(tutorial.getDescription());
            tmpTutorial.setPublished(tutorial.isPublished());

            // save
            Tutorial _tutorial = sampleTutorialService.save(tmpTutorial);

            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("tutorials/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") Long id, @RequestBody Tutorial tutorial) {
        Optional<Tutorial> _tutorial = sampleTutorialService.findById(id);

        if (_tutorial.isPresent()) {
            _tutorial.get().setTitle(tutorial.getTitle());
            _tutorial.get().setPublished(tutorial.isPublished());
            _tutorial.get().setDescription(tutorial.getDescription());

            return new ResponseEntity<>(sampleTutorialService.save(_tutorial.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("tutorial/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") Long id) {
        try {
            sampleTutorialService.deletedById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
