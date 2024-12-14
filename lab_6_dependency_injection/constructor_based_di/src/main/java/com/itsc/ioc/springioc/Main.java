package com.itsc.ioc.springioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beansConfig.xml");

        Student student = context.getBean("student", Student.class);
        System.out.println(student.getFullName());
    }
}
