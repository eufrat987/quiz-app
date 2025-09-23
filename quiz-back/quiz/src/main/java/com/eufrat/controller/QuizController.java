package com.eufrat.controller;

import com.eufrat.dto.QuizResponse;
import com.eufrat.service.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

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
    @PostMapping
    public int create(@RequestBody Map<String, Object> b) {
        quizService.create();
//        b.entrySet().forEach(stringStringEntry -> {
//            System.out.println(stringStringEntry.getKey() + ' ' + stringStringEntry.getValue());
//        });
        return 0;
    }

}
