package com.itsc.ioc.springioc;

import org.springframework.stereotype.Component;

@Component
public class HighSchool implements SchoolInterface {
    private String schoolName;

    public String getSchoolName() {
        return "HighSchool: " + schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}