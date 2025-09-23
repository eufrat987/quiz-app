package com.eufrat.validator;

import com.eufrat.model.Question;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AnswerValidator implements ConstraintValidator<AnswerValidatorAnnotation, Object> {
    @Override
    public void initialize(AnswerValidatorAnnotation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext context) {
        try {
            if (o instanceof Question) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Answer must be one of them: " + ((Question) o).getChoices())
                        .addConstraintViolation();
                return ((Question) o).getChoices().contains(((Question) o).getAnswer());
            }
            throw new IllegalArgumentException("Only for Answer model purpose");
        } catch (Exception e) {
            return false;
        }
    }
}
