package com.itsc.ioc.springioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.itsc.ioc.springioc");
        MessageSender messageSender = context.getBean(MessageSender.class);

        messageSender.sendMessage("This is a message");
    }
}
