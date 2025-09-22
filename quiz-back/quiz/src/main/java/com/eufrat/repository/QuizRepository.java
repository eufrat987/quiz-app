package com.eufrat.repository;

import com.eufrat.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM t_quiz ORDER BY RANDOM() LIMIT 1")
    Optional<Quiz> getRandomQuiz();

}
