package com.itsc.aop.lab;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TaskApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.itsc.aop.lab");
		// context.register(LoggingAspect.class);
		// context.register(TaskService.class);
		// context.refresh();

		TaskServiceInterface taskService = context.getBean(TaskServiceInterface.class);

		taskService.createTask("Prepare presentation");
		taskService.updateTask("123", "Prepare report");
		taskService.deleteTask("123");

		context.close();
	}
}
