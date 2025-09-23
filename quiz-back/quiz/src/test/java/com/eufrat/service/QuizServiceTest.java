package com.eufrat.service;

import com.eufrat.model.Question;
import com.eufrat.model.Quiz;
import com.eufrat.repository.QuizRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QuizServiceTest {
    @Mock
    private QuizRepository quizRepository;

    @InjectMocks
    private QuizService quizService;

    @BeforeEach
    void setUp() {
        var quiz = mock(Quiz.class);
        var question1 = mock(Question.class);
        var question2 = mock(Question.class);
        var question3 = mock(Question.class);

        when(this.quizRepository.findById(eq(1L))).thenReturn(Optional.of(quiz));
        when(quiz.getQuestions()).thenReturn(List.of(question1, question2, question3));
        when(question1.getId()).thenReturn(1L);
        when(question1.getAnswer()).thenReturn("A1");
        when(question2.getId()).thenReturn(2L);
        when(question2.getAnswer()).thenReturn("A2");
        when(question3.getId()).thenReturn(3L);
        when(question3.getAnswer()).thenReturn("A3");
    }

    @Test
    public void shouldReturnZeroScoreWhenAllAnswersAreWrong() {
        var requestMap = new HashMap<String, Map<String, String>>();
        requestMap.put("_1", Map.of("1", "A"));
        requestMap.put("_2", Map.of("2", "A"));
        requestMap.put("_3", Map.of("3", "A"));

        var score = quizService.getScore(1L, requestMap);

        Assertions.assertEquals(0, score);
    }

    @Test
    public void shouldReturnFullScoreWhenAllAnswersAreCorrect() {
        var requestMap = new HashMap<String, Map<String, String>>();
        requestMap.put("_1", Map.of("1", "A1"));
        requestMap.put("_2", Map.of("2", "A2"));
        requestMap.put("_3", Map.of("3", "A3"));

        var score = quizService.getScore(1L, requestMap);

        Assertions.assertEquals(3, score);
    }

}