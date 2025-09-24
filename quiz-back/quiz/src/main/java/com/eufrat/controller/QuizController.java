package com.eufrat.controller;

import com.eufrat.dto.QuizResponse;
import com.eufrat.service.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/quiz")
@AllArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @GetMapping
    public List<QuizResponse> getAllQuizes() {
        return quizService.getAllQuizes();
    }

    @GetMapping("/{id}")
    public Optional<QuizResponse> getQuiz(@PathVariable("id") Long id) {
        return quizService.getQuiz(id);
    }

    @PostMapping("/{id}")
    public int create(@PathVariable("id") Long id, @RequestBody Map<String, Map<String, String>> request) {
        return quizService.getScore(id, request);
    }
}
