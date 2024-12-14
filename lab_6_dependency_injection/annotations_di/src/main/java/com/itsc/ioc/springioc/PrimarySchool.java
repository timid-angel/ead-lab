package com.itsc.ioc.springioc;

import org.springframework.stereotype.Component;

@Component
public class PrimarySchool implements SchoolInterface {
    private String schoolName;

    public String getSchoolName() {
        return "Primary School: " + schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
