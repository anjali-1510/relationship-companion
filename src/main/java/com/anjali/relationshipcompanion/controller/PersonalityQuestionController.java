package com.anjali.relationshipcompanion.controller;

import com.anjali.relationshipcompanion.model.PersonalityQuestion;
import com.anjali.relationshipcompanion.service.PersonalityQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/personality/questions")
public class PersonalityQuestionController {

    private final PersonalityQuestionService personalityQuestionService;

    public PersonalityQuestionController(
            PersonalityQuestionService personalityQuestionService) {

        this.personalityQuestionService = personalityQuestionService;
    }

    @GetMapping
    public List<PersonalityQuestion> getAllQuestions() {
        return personalityQuestionService.getAllQuestions();
    }
}