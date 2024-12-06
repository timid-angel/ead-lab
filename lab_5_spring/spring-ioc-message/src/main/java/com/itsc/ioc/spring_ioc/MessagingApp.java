package com.itsc.ioc.spring_ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessagingApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("message-config.xml");
        MessageService smsSerivce = context.getBean("sms", MessageService.class);
        MessageService emailService = context.getBean("email", MessageService.class);

        smsSerivce.sendMessage("This is a message.");
        emailService.sendMessage("This is a message.");
    }
}
