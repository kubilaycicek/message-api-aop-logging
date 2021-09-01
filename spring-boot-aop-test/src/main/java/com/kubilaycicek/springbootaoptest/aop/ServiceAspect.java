package com.kubilaycicek.springbootaoptest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    @Before("execution(* com.kubilaycicek.springbootaoptest.service.*.*(..))")
    public void before(JoinPoint joinPoint) {
        String log = new StringBuilder().append("Before")
                .append("Signature : " + joinPoint.getSignature() + " ")
                .append("This :" + joinPoint.getThis()).toString();

        System.out.println(log);
    }

    @After("execution(* com.kubilaycicek.springbootaoptest.service.*.*(..))")
    public void after(JoinPoint joinPoint) {
        String log = new StringBuilder().append("After")
                .append("Signature : " + joinPoint.getSignature() + " ")
                .append("This :" + joinPoint.getThis()).toString();

        System.out.println(log);
    }
}
