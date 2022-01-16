package com.example.forumalex.service;

import com.example.forumalex.domain.Question;
import com.example.forumalex.repository.QuestionsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ForumService {
    private final QuestionsRepository questionsRepository;

    public ForumService(QuestionsRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
    }

    public Set<Question> findAll() {
        return questionsRepository
                .findAll()
                .stream()
                .collect(Collectors.toUnmodifiableSet());
    }

    public Optional<Question> save(Question question) {
        return questionsRepository.save(question);
    }

    public Optional<Question> findById(int id){ return questionsRepository.findById(id);}

    public  void deleteById(int id){ questionsRepository.deleteById(id);}
}
