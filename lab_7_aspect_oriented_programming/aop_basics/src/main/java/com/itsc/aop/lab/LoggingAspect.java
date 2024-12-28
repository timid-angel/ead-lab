package com.itsc.aop.lab;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* com.itsc.aop.lab.Calculator.*(..))")
    public void logMethodCall(final JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Method called: " + methodName);
    }

    @After("execution(* com.itsc.aop.lab.Calculator.*(..))")
    public void afterAdvice(final JoinPoint joinPoint) {
        System.out.println("After advice: Performing post-processing...");
    }

    @AfterReturning(pointcut = "execution(* com.itsc.aop.lab.Calculator.*(..))", returning = "result")
    public void afterReturningAdvice(Object result) {
        System.out.println("After returning advice: Method returned with result: " + result);
    }

    @AfterThrowing(pointcut = "execution(* com.itsc.aop.lab.Calculator.*(..))", throwing = "exception")
    public void afterThrowingAdvice(Exception exception) {
        System.out.println("After throwing advice: Method threw an exception: " + exception);
    }

    @Around("execution(* com.itsc.aop.lab.Calculator.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around advice: Before method execution");
        Object result = null;
        try {
            result = joinPoint.proceed();
            System.out.println("Around advice: After method execution");
        } catch (Throwable throwable) {
            System.out.println("Around advice: Exception occurred: " + throwable);
            throw throwable;
        }

        return result;
    }
}
