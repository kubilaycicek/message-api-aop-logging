# 

## Message API (Aspect Oriented Programming)
| Route  | HTTP Verb  |POST Body   |Description   |
|---|---|---|---|
| localhost:9090/chat/api/v1/message  |`GET`   |   | Get Message
| localhost:9090/chat/api/v1/message  |`POST`   | { message:"text"} | Check Message



```
package com.kubilaycicek.springbootaoptest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

	@Before("execution(* com.kubilaycicek.springbootaoptest.service.*.*(..))")
	public void before(JoinPoint joinPoint) {
		String log = new StringBuilder().append("Before").append("Signature : " + joinPoint.getSignature() + " ").append("This :" + joinPoint.getThis()).toString();

		System.out.println(log);
	}

	@After("execution(* com.kubilaycicek.springbootaoptest.service.*.*(..))")
	public void after(JoinPoint joinPoint) {
		String log = new StringBuilder().append("After").append("Signature : " + joinPoint.getSignature() + " ").append("This :" + joinPoint.getThis()).toString();

		System.out.println(log);
	}

	@AfterReturning("execution(* com.kubilaycicek.springbootaoptest.service.*.*(..))")
	public void afterReturning(JoinPoint joinPoint) {
		String log = new StringBuilder().append("After Returning").append("Signature : " + joinPoint.getSignature() + " ").append("This :" + joinPoint.getThis()).toString();

		System.out.println(log);
	}

	@AfterThrowing("execution(* com.kubilaycicek.springbootaoptest.service.*.*(..))")
	public void afterThrowing(JoinPoint joinPoint) {
		String log = new StringBuilder().append("After Throwing").append("Signature : " + joinPoint.getSignature() + " ").append("This :" + joinPoint.getThis()).toString();
		System.out.println(log);
	}

}
```
