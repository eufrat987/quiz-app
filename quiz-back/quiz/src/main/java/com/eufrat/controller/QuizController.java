package com.eufrat.controller;

import com.eufrat.dto.QuizResponse;
import com.eufrat.service.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/quiz")
@AllArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/random")
    public Optional<QuizResponse> getQuiz() {
        return quizService.getRandomQuiz();
    }

    @PostMapping
    public void create() {
        quizService.creat();
    }

}
