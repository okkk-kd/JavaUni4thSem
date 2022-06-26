package ru.mirea.Task7.Bridge;

public class Switch {
    private Device device;

    public Switch(Device device){
        this.device = device;
    }

    public void switchDevice(){
        if(device.isTurned())
            device.turnOff();
        else
            device.turnOn();
    }
}
