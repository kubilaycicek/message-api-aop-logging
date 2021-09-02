# 

## Message API (Aspect Oriented Programming)
| Route  | HTTP Verb  |POST Body   |Description   |
|---|---|---|---|
| localhost:9090/chat/api/v1/message  |`GET`   |   | Get Message
| localhost:9090/chat/api/v1/message  |`POST`   | { message:"text"} | Check Message


## Aspect Class
```

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

        log.info(new StringBuilder().append("Before").append(SIGNATURE_TEXT + joinPoint.getSignature() + " ").append(THIS_TEXT + joinPoint.getThis()).toString());
    }

    @After("execution(* com.kubilaycicek.springbootaoptest.service.*.*(..))")
    public void after(JoinPoint joinPoint) {
        log.info(new StringBuilder().append("After").append(SIGNATURE_TEXT + joinPoint.getSignature() + " ").append(THIS_TEXT + joinPoint.getThis()).toString());
    }

    @AfterReturning("execution(* com.kubilaycicek.springbootaoptest.service.*.*(..))")
    public void afterReturning(JoinPoint joinPoint) {
        log.info(new StringBuilder().append("After Returning").append(SIGNATURE_TEXT + joinPoint.getSignature() + " ").append(THIS_TEXT + joinPoint.getThis()).toString());
    }

    @AfterThrowing("execution(* com.kubilaycicek.springbootaoptest.service.*.*(..))")
    public void afterThrowing(JoinPoint joinPoint) {
        log.error(new StringBuilder().append("After Throwing").append(SIGNATURE_TEXT + joinPoint.getSignature() + " ").append(THIS_TEXT + joinPoint.getThis()).toString());
    }


```
