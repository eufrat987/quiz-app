package com.eufrat.service;

import com.eufrat.dto.QuestionDto;
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
                    .title(quiz.getTitle())
                    .questions(quiz.getQuestions().stream().map(q -> {
                        return QuestionDto.builder()
                                .question(q.getQuestion())
                                .choices(q.getChoices())
                                .build();
                    }).toList())
                    .build();
        });
    }

    public void creat() {
        var x = new Quiz();
        x.setTitle("T");
        var q1 = new Question();
        q1.setQuestion("AAAA?");
        q1.setChoices(new String[]{"1", "2", "3", "4"});
        var q2 = new Question();
        q2.setQuestion("VVVV");
        q2.setChoices(new String[]{"1", "2", "3", "4"});
        x.setQuestions(List.of(q1, q2));
        quizRepository.save(x);
    }

}
