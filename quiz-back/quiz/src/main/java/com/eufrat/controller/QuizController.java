package com.eufrat.controller;

import com.eufrat.dto.QuizResponse;
import com.eufrat.service.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/quiz")
@AllArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/random")
    @ResponseStatus(HttpStatus.OK)
    public Optional<QuizResponse> getQuiz() {
        return quizService.getRandomQuiz();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(":id")
    public int create(@PathVariable("id") Long id, @RequestBody Map<String, Map<String, String>> request) {
//        quizService.create();
        return quizService.getScore(id, request);
    }

}
