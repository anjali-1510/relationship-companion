package com.anjali.relationshipcompanion.dto;

public class PersonalityAnswerRequest {

    private Long questionId;
    private Integer score;

    public PersonalityAnswerRequest() {
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}