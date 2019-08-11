package com.mithunkhatri.spring.mongodbcrud.configurations;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AspectConfiguration {

    @Before(value = "execution(* com.mithunkhatri.spring.mongodbcrud.services.BookService.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        log.info("Entering method: BookService::" + joinPoint.getSignature().getName());
    }

    @After(value = "execution(* com.mithunkhatri.spring.mongodbcrud.services.BookService.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        log.info("Exiting method: BookService::" + joinPoint.getSignature().getName());
    }
}
