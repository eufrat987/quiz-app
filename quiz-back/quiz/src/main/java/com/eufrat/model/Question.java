package com.eufrat.model;

import com.eufrat.validator.AnswerValidatorAnnotation;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@AnswerValidatorAnnotation
@Entity(name = "t_question")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Question is mandatory")
    private String question;
    @NotEmpty(message = "Question must have options to choose from")
    @Column(columnDefinition = "text[]")
    private List<String> choices;
    @NotBlank(message = "Question must have answer")
    private String answer;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
}
