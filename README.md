# 

## Message API (Aspect Oriented Programming)
| Route  | HTTP Verb  |POST Body   |Description   |
|---|---|---|---|
| localhost:9090/chat/api/v1/message  |`GET`   |   | Get Message
| localhost:9090/chat/api/v1/message  |`POST`   | { message:"text"} | Check Message


## Aspect Class
```

package com.kubilaycicek.springbootaoptest.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ServiceAspect {

    private static final String SIGNATURE_TEXT = "Signature : ";
    private static final String THIS_TEXT = "This : ";

    @Before("execution(* com.kubilaycicek.springbootaoptest.service.*.*(..))")
    public void before(JoinPoint joinPoint) {

        log.info("Before " + SIGNATURE_TEXT + joinPoint.getSignature() + " " + THIS_TEXT + " " + joinPoint.getThis());
    }

    @After("execution(* com.kubilaycicek.springbootaoptest.service.*.*(..))")
    public void after(JoinPoint joinPoint) {
        log.info("After " + SIGNATURE_TEXT + joinPoint.getSignature() + " " + THIS_TEXT + " " + joinPoint.getThis());
    }

    @AfterReturning("execution(* com.kubilaycicek.springbootaoptest.service.*.*(..))")
    public void afterReturning(JoinPoint joinPoint) {
        log.info("After Returning" + SIGNATURE_TEXT + joinPoint.getSignature() + " " + THIS_TEXT + " " + joinPoint.getThis());
    }

    @AfterThrowing("execution(* com.kubilaycicek.springbootaoptest.service.*.*(..))")
    public void afterThrowing(JoinPoint joinPoint) {
        log.info("After Throwing" + SIGNATURE_TEXT + joinPoint.getSignature() + " " + THIS_TEXT + " " + joinPoint.getThis());
    }

}

```
