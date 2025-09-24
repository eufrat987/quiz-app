package com.eufrat.service;

import com.eufrat.dto.QuestionResponse;
import com.eufrat.dto.QuizResponse;
import com.eufrat.model.Question;
import com.eufrat.model.Quiz;
import com.eufrat.repository.QuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;

    public List<QuizResponse> getAllQuizes() {
        return quizRepository.findAll().stream().map(quiz -> QuizResponse.builder()
                .id(quiz.getId())
                .title(quiz.getTitle())
                .numOfQuestions(quiz.getNumOfQuestions())
                .build()).toList();
    }

    public Optional<QuizResponse> getQuiz(Long id) {
        if (id == 0) {
            return getRandomQuiz();
        }
        return quizRepository.findById(id).map(quiz -> QuizResponse.builder()
                .id(quiz.getId())
                .title(quiz.getTitle())
                .numOfQuestions(quiz.getNumOfQuestions())
                .questions(quiz.getQuestions().stream().map(q -> QuestionResponse.builder()
                        .id(q.getId())
                        .question(q.getQuestion())
                        .choices(q.getChoices())
                        .build()).toList())
                .build());
    }

    public Optional<QuizResponse> getRandomQuiz() {
        return quizRepository.getRandomQuiz().map(quiz -> QuizResponse.builder()
                .id(quiz.getId())
                .title(quiz.getTitle())
                .numOfQuestions(quiz.getNumOfQuestions())
                .questions(quiz.getQuestions().stream().map(q -> QuestionResponse.builder()
                        .id(q.getId())
                        .question(q.getQuestion())
                        .choices(q.getChoices())
                        .build()).toList())
                .build());
    }

    public int getScore(Long quizId, Map<String, Map<String, String>> request) {
        var score = 0;
        var quiz = quizRepository.findById(quizId).orElseThrow();
        var mapIterator = request.values().iterator();
        var answers = new HashMap<Long, String>();

        while (mapIterator.hasNext()) {
            var map = mapIterator.next();
            for (var entry : map.entrySet()) {
                answers.put(Long.valueOf(entry.getKey()), entry.getValue());
            }
        }

        for (var question : quiz.getQuestions()) {
            if (Objects.equals(question.getAnswer(), answers.get(question.getId()))) {
                score++;
            }
        }

        return score;
    }

}
