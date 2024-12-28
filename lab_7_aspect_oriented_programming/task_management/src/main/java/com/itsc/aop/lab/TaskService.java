package com.itsc.aop.lab;

import org.springframework.stereotype.Component;

@Component
public class TaskService implements TaskServiceInterface {
    @Override
    public void createTask(String taskName) {
        System.out.println("Task created: " + taskName);
    }

    @Override
    public void updateTask(String taskID, String newTaskName) {
        System.out.println("Task updated: " + taskID + " -> " + newTaskName);
    }

    @Override
    public void deleteTask(String taskID) {
        System.out.println("Task deleted: " + taskID);
    }

}
