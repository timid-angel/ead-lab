package com.itsc.ioc.springioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beansConfig.xml");

        MusicPlayerInterface cdPlayer = (MusicPlayerInterface) context.getBean("cdPlayer");
        cdPlayer.play();
        cdPlayer.outputSound();
        cdPlayer.stop();
    }
}
