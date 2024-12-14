package com.itsc.ioc.springioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Student {
    private String name;
    private SchoolInterface school;

    // @Autowired
    // public Student(@Qualifier("highSchool") SchoolInterface school) {
    // this.school = school;
    // }

    @Autowired
    public void setSchool(@Qualifier("highSchool") SchoolInterface school) {
        this.school = school;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void Details() {
        System.out.println("Student Details: " + name + ", " + school.getSchoolName());
    }

    public SchoolInterface getSchool() {
        return school;
    }
}
