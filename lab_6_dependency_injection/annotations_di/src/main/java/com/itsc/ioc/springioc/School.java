package com.itsc.ioc.springioc;

import org.springframework.stereotype.Component;

@Component
public class School {
    private String schoolName;

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }
}
