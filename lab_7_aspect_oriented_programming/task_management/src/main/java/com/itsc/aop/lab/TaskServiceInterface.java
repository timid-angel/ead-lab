package com.itsc.aop.lab;

import org.springframework.stereotype.Component;

@Component
public interface TaskServiceInterface {
    void createTask(String taskName);

    void updateTask(String taskID, String newTaskName);

    void deleteTask(String taskID);
}
