package com.itsc.aop.lab;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LabApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.itsc.aop.lab");

		Calculator calculator = context.getBean(Calculator.class);
		System.out.println(calculator.add(1, 2));
		context.close();
	}
}
