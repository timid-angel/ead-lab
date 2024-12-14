package com.itsc.ioc.springioc;

public interface MusicPlayerInterface {
    void play();

    void stop();

    void setOutputDevice(OutputDeviceInterface outputDevice);

    void outputSound();
}
