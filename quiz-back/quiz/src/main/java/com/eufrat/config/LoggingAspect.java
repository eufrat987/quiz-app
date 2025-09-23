package com.eufrat.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Around("execution(* com.eufrat..*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        var name = joinPoint.getSignature().getName();
        var declaringType = joinPoint.getSignature().getDeclaringType();

        log.trace(declaringType + " " + name + " " + Arrays.toString(joinPoint.getArgs()));
        var result = joinPoint.proceed();
        log.trace("DONE " + declaringType + " " + name);
        return result;
    }


}
