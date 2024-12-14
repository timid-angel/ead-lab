package com.itsc.ioc.springioc;

public class CdPlayer implements MusicPlayerInterface {
    private OutputDeviceInterface outputDevice;

    @Override
    public void play() {
        System.out.println("CD player playing");
    }

    @Override
    public void stop() {
        System.out.println("CD player stopped");
    }

    @Override
    public void setOutputDevice(OutputDeviceInterface outputDevice) {
        this.outputDevice = outputDevice;
    }

    @Override
    public void outputSound() {
        outputDevice.outputSound();
    }
}
