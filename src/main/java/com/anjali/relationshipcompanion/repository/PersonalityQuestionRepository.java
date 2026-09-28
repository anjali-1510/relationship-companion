package com.anjali.relationshipcompanion.repository;

import com.anjali.relationshipcompanion.model.PersonalityQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalityQuestionRepository extends JpaRepository<PersonalityQuestion, Long> {
}