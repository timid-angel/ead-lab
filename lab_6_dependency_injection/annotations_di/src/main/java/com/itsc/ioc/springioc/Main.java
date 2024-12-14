package com.itsc.ioc.springioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.itsc.ioc");
        // Student s = context.getBean(Student.class);

        SchoolInterface school = context.getBean(HighSchool.class);
        Student s = context.getBean(Student.class);
        s.setName("John");
        school.setSchoolName("AAiT");
        s.Details();
    }
}
