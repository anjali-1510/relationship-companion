package com.anjali.relationshipcompanion.controller;

import com.anjali.relationshipcompanion.model.PersonalityAnswer;
import com.anjali.relationshipcompanion.service.PersonalityAnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/personality/answers")
public class PersonalityAnswerController {

    private final PersonalityAnswerService personalityAnswerService;

    public PersonalityAnswerController(
            PersonalityAnswerService personalityAnswerService) {

        this.personalityAnswerService = personalityAnswerService;
    }

    @PostMapping
    public ResponseEntity<PersonalityAnswer> saveAnswer(
            @RequestBody PersonalityAnswer answer) {

        PersonalityAnswer savedAnswer =
                personalityAnswerService.saveAnswer(answer);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedAnswer);
    }
}