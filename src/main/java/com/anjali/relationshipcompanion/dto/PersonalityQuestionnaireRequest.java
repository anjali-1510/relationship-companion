package com.anjali.relationshipcompanion.dto;

import java.util.List;

public class PersonalityQuestionnaireRequest {

    private Long userId;

    private List<PersonalityAnswerRequest> answers;

    public PersonalityQuestionnaireRequest() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<PersonalityAnswerRequest> getAnswers() {
        return answers;
    }

    public void setAnswers(List<PersonalityAnswerRequest> answers) {
        this.answers = answers;
    }
}