package com.eufrat.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = AnswerValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface AnswerValidatorAnnotation {
    String message() default "Will be override by validator";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
