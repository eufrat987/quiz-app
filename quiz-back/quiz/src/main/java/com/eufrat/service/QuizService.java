package com.eufrat.service;

import com.eufrat.dto.QuizResponse;
import com.eufrat.repository.QuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;

    public Optional<QuizResponse> getRandomQuiz() {
        return quizRepository.getRandomQuiz().map(quiz -> {
            return QuizResponse.builder().title(quiz.getTitle()).build();
        });
    }

}
