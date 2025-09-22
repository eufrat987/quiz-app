package com.eufrat.controller;

import com.eufrat.dto.QuizResponse;
import com.eufrat.service.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/quiz")
@AllArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @GetMapping
    public Optional<QuizResponse> getQuiz() {
        return quizService.getRandomQuiz();
    }

    @PostMapping
    public void create() {
        quizService.creat();
    }

}
