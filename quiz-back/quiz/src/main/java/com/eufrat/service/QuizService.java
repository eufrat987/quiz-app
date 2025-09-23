package com.eufrat.service;

import com.eufrat.dto.QuestionResponse;
import com.eufrat.dto.QuizResponse;
import com.eufrat.model.Question;
import com.eufrat.model.Quiz;
import com.eufrat.repository.QuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;

    public Optional<QuizResponse> getRandomQuiz() {
        return quizRepository.getRandomQuiz().map(quiz -> {
            return QuizResponse.builder()
                    .id(quiz.getId())
                    .title(quiz.getTitle())
                    .questions(quiz.getQuestions().stream().map(q -> {
                        return QuestionResponse.builder()
                                .id(q.getId())
                                .question(q.getQuestion())
                                .choices(q.getChoices())
                                .build();
                    }).toList())
                    .build();
        });
    }

    public void create() {
        var x = new Quiz();
        var q1 = new Question();
        var q2 = new Question();
        var q3 = new Question();

        q1.setQuiz(x);
        q1.setQuestion("What is the capital of Poland??");
        q1.setChoices(new String[]{"Opole", "Gdańsk", "Warszawa", "Gniezno"});

        q2.setQuestion("What is the capital of France");
        q2.setChoices(new String[]{"Haguenau", "Ribeauvillé", "Paris", "Mont-de-Marsan"});
        q2.setQuiz(x);

        q3.setQuiz(x);
        q3.setQuestion("What is the capital of Germany");
        q3.setChoices(new String[]{"Hamburg", "Dortmund", "Dresden:", "Berlin"});

        x.setTitle("Geography");
        x.setQuestions(List.of(q1, q2, q3));
        quizRepository.save(x);
    }

}
