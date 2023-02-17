package com.example.practice_config.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class ServiceLogger {
    private Logger logger = LoggerFactory.getLogger(ServiceLogger.class);

    @Before("execution(* com.example.practice_config.service.*.*(..))")
    public void beforeService(JoinPoint joinPoint) {
        logger.info("Before service: " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.example.practice_config.service.*.*(..))")
    public void afterService(JoinPoint joinPoint) {
        logger.info("After service: " + joinPoint.getSignature().getName());
    }

    @AfterThrowing(value = "execution(* com.example.practice_config.service.*.*(..))", throwing = "exception")
    public void afterThrowingService(JoinPoint joinPoint, Exception exception) {
        logger.info("Throwing error: " + exception.toString() + " at " + joinPoint.getSignature().getName());
    }
}
