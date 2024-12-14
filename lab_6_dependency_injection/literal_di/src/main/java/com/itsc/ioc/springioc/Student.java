package com.itsc.ioc.springioc;

import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private Address address;
    private List<Subject> subjects;

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void getDetails() {
        System.out.println("Name: " + getFullName());
        System.out.println("Subjects: ");
        for (Subject subject : subjects) {
            System.out.println("\t- " + subject.getSubjectName());
        }

    }
}
