package com.itsc.ioc.springioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.itsc.ioc.springioc")
public class AppConfig {

    // @Bean
    // public Student student() {
    // Student student = new Student();
    // student.setName("John");
    // return student;
    // }

    // @Bean
    // public SchoolInterface primarySchool() {
    // return new PrimarySchool();
    // }

    // @Bean
    // public SchoolInterface highSchool() {
    // return new HighSchool();
    // }
}
