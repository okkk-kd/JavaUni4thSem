package ru.mirea.Task7.Bridge;

public class Generator implements Device{
    private int power;
    private boolean turned;

    public Generator(int power){
        this.power = power;
        turned = true;
    }

    @Override
    public void turnOff() {
        turned = false;
    }

    @Override
    public void turnOn() {
        turned = true;
    }

    @Override
    public boolean isTurned() {
        return turned;
    }
}
