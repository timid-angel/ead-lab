package com.itsc.aop.lab;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @After("execution(* *.createTask(..)) || execution(* *.updateTask(..)) || execution(* *.deleteTask(..))")
    public void logTaskActions() {
        System.out.println("Logging: Task action performed");
    }
}
