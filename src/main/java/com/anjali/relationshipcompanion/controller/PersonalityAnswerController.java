package com.anjali.relationshipcompanion.controller;

import com.anjali.relationshipcompanion.dto.PersonalityQuestionnaireRequest;
import com.anjali.relationshipcompanion.model.PersonalityAnswer;
import com.anjali.relationshipcompanion.service.PersonalityAnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personality/answers")
public class PersonalityAnswerController {

    private final PersonalityAnswerService personalityAnswerService;

    public PersonalityAnswerController(
            PersonalityAnswerService personalityAnswerService) {

        this.personalityAnswerService = personalityAnswerService;
    }

    @PostMapping
    public ResponseEntity<List<PersonalityAnswer>> saveAnswers(
            @RequestBody PersonalityQuestionnaireRequest request) {

        List<PersonalityAnswer> savedAnswers =
                personalityAnswerService.saveAnswers(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedAnswers);
    }
}