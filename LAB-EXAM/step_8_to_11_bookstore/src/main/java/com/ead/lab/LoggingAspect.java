// Nathan Mesfin Shiferaw - UGR/0534/14
package com.ead.lab;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
        @Before("execution(* com.ead.lab.BookRegistrationServlet.*(..))")
        public void logBookRegistrationServletMethods(JoinPoint joinPoint) {
                System.out.println(
                                "Logger: BookRegistrationServlet method called: "
                                                + joinPoint.getSignature().getName());
        }

        @Before("execution(* com.ead.lab.DisplayBooksServlet.*(..))")
        public void logDisplayBooksServletMethods(JoinPoint joinPoint) {
                System.out.println(
                                "Logger: DisplayBooksServlet method called: " +
                                                joinPoint.getSignature().getName());
        }

        @Before("execution(* com.ead.lab.DeleteBookServlet.*(..))")
        public void logDeleteBookServletMethods(JoinPoint joinPoint) {
                System.out.println(
                                "Logger: DeleteBookServlet method called: " +
                                                joinPoint.getSignature().getName());
        }

        @Before("execution(* com.ead.lab.SearchBooksServlet.*(..))")
        public void logSearchBooksServletMethods(JoinPoint joinPoint) {
                System.out.println(
                                "Logger: SearchBooksServlet method called: " +
                                                joinPoint.getSignature().getName());
        }
}
