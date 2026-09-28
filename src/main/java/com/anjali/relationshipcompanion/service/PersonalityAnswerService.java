package com.anjali.relationshipcompanion.service;

import com.anjali.relationshipcompanion.model.PersonalityAnswer;
import com.anjali.relationshipcompanion.repository.PersonalityAnswerRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonalityAnswerService {

    private final PersonalityAnswerRepository personalityAnswerRepository;

    public PersonalityAnswerService(
            PersonalityAnswerRepository personalityAnswerRepository) {

        this.personalityAnswerRepository = personalityAnswerRepository;
    }

    public PersonalityAnswer saveAnswer(PersonalityAnswer answer) {
        return personalityAnswerRepository.save(answer);
    }
}