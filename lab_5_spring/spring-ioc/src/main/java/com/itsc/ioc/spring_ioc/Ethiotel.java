package com.itsc.ioc.spring_ioc;

public class Ethiotel implements SimInterface {
    private String operatorName;
    private String phoneNumber;

    // constructor
    public Ethiotel(String operatorName, String phoneNumber) {
        this.operatorName = operatorName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void calling() {
        System.out.println("Calling with Ethiotel Sim");
    }

    @Override
    public void data() {
        System.out.println("Browsing with Ethiotel Sim");
    }

    @Override
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    @Override
    public String getOperatorName() {
        return operatorName;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
