package com.anjali.relationshipcompanion.service;

import com.anjali.relationshipcompanion.model.PersonalityQuestion;
import com.anjali.relationshipcompanion.repository.PersonalityQuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalityQuestionService {

    private final PersonalityQuestionRepository personalityQuestionRepository;

    public PersonalityQuestionService(
            PersonalityQuestionRepository personalityQuestionRepository) {

        this.personalityQuestionRepository = personalityQuestionRepository;
    }

    public List<PersonalityQuestion> getAllQuestions() {
        return personalityQuestionRepository.findAll();
    }
}