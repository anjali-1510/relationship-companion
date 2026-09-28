package com.anjali.relationshipcompanion.model;

import jakarta.persistence.*;

@Entity
@Table(name = "personality_questions")
public class PersonalityQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String question;

    @Column(nullable = false, length = 50)
    private String trait;

    // Default constructor required by JPA
    public PersonalityQuestion() {
    }

    public PersonalityQuestion(String question, String trait) {
        this.question = question;
        this.trait = trait;
    }

    public Long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTrait() {
        return trait;
    }

    public void setTrait(String trait) {
        this.trait = trait;
    }
}