package com.example.forumalex.repository;

import com.example.forumalex.domain.Question;

import java.util.Optional;
import java.util.Set;

public interface QuestionsRepository {
    Set<Question> findAll();
    Optional<Question> findById(int id);
    Optional<Question> save(Question question);
    //Set<Question> findQuestionByUser(String user);
    void deleteById(int id);
}
