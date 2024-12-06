package com.itsc.ioc.spring_ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mobile {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beansConfig.xml");

        SimInterface ethioTel = context.getBean("ethiotel", SimInterface.class);
        SimInterface safaricom = context.getBean("safari", SimInterface.class);

        System.out.println("Ethiotel Operator: " + ethioTel.getOperatorName() + " works with phone number: "
                + ethioTel.getPhoneNumber());
        System.out.println("Safaricom Operator: " + safaricom.getOperatorName() + " works with phone number: "
                + safaricom.getPhoneNumber());
    }
}