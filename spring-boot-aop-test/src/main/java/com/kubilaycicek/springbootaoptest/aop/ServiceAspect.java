package com.kubilaycicek.springbootaoptest.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Slf4j
@Component
public class ServiceAspect {

    private static final String SIGNATURE_TEXT = "Signature : ";
    private static final String THIS_TEXT = "This : ";

    @Before("execution(* com.kubilaycicek.springbootaoptest.service.*.*(..))")
    public void before(JoinPoint joinPoint) {
        log.info("Before Aspect " + SIGNATURE_TEXT + joinPoint.getSignature() + " " + THIS_TEXT + " " + joinPoint.getThis());
        log.info("=====================================================================================");
    }

    @After("execution(* com.kubilaycicek.springbootaoptest.service.*.*(..))")
    public void after(JoinPoint joinPoint) {
        log.info("After Aspect" + SIGNATURE_TEXT + joinPoint.getSignature() + " " + THIS_TEXT + " " + joinPoint.getThis());
        log.info("=====================================================================================");
    }

    @AfterReturning("execution(* com.kubilaycicek.springbootaoptest.service.*.*(..))")
    public void afterReturning(JoinPoint joinPoint) {
        log.info("After Returning  Aspect " + SIGNATURE_TEXT + joinPoint.getSignature() + " " + THIS_TEXT + " " + joinPoint.getThis());
        log.info("=====================================================================================");
    }

    @AfterThrowing("execution(* com.kubilaycicek.springbootaoptest.service.*.*(..))")
    public void afterThrowing(JoinPoint joinPoint) {
        log.warn("After Throwing Aspect " + SIGNATURE_TEXT + joinPoint.getSignature() + " " + THIS_TEXT + " " + joinPoint.getThis());
        log.info("=====================================================================================");
    }

    @Around("@annotation(com.kubilaycicek.springbootaoptest.annotation.LogExecutionTime)")
    public Object methodTimeLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();


        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        StopWatch stopWatch = new StopWatch(className + "->" + methodName);
        stopWatch.start(methodName);
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();


        log.info(stopWatch.prettyPrint());

        return result;
    }



}