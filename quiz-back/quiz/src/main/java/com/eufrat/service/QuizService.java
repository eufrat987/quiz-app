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

    public void create() {
        var x = new Quiz();
        var q1 = new Question();
        var q2 = new Question();
        var q3 = new Question();

        q1.setQuiz(x);
        q1.setQuestion("What is the capital of Poland??");
        q1.setChoices(List.of("Opole", "Gdańsk", "Warszawa", "Gniezno"));
        q1.setAnswer("Warszawa");

        q2.setQuestion("What is the capital of France");
        q2.setChoices(List.of("Haguenau", "Ribeauvillé", "Paris", "Mont-de-Marsan"));
        q2.setQuiz(x);
        q2.setAnswer("Paris");

        q3.setQuiz(x);
        q3.setQuestion("What is the capital of Germany");
        q3.setChoices(List.of("Hamburg", "Dortmund", "Dresden:", "Berlin"));
        q3.setAnswer("Berlin");

        x.setTitle("Geography");
        x.setQuestions(List.of(q1, q2, q3));
        x.setNumOfQuestions(3);
        quizRepository.save(x);
    }

}
