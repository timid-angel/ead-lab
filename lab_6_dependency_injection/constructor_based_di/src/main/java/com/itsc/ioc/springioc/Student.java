package com.itsc.ioc.springioc;

import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private List<Subject> subjects; // collection of subjects

    public Student(String firstName, String lastName,
            List<Subject> subjects) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.subjects = subjects;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public List<Subject> getSubjects() {
        return subjects;

    }

    public void getDetails() {
        System.out.println("Name: " + getFullName());
        System.out.println("Subjects: ");
        for (Subject subject : subjects) {
            System.out.println("- " +

                    subject.getSubjectName());

        }
    }
}