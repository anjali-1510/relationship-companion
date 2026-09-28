package com.anjali.relationshipcompanion.service;

import com.anjali.relationshipcompanion.dto.PersonalityAnswerRequest;
import com.anjali.relationshipcompanion.dto.PersonalityQuestionnaireRequest;
import com.anjali.relationshipcompanion.model.PersonalityAnswer;
import com.anjali.relationshipcompanion.repository.PersonalityAnswerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonalityAnswerService {

    private final PersonalityAnswerRepository personalityAnswerRepository;

    public PersonalityAnswerService(
            PersonalityAnswerRepository personalityAnswerRepository) {

        this.personalityAnswerRepository = personalityAnswerRepository;
    }

    public List<PersonalityAnswer> saveAnswers(
            PersonalityQuestionnaireRequest request) {

        List<PersonalityAnswer> answers = new ArrayList<>();

        for (PersonalityAnswerRequest answerRequest : request.getAnswers()) {

            PersonalityAnswer answer = new PersonalityAnswer();

            answer.setUserId(request.getUserId());
            answer.setQuestionId(answerRequest.getQuestionId());
            answer.setScore(answerRequest.getScore());

            answers.add(answer);
        }

        return personalityAnswerRepository.saveAll(answers);
    }
}