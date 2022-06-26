package ru.mirea.Task7.Adapter;

public class AmericanOven {
    private int temperature;

    AmericanOven(){}

    AmericanOven(int temperature){
        this.temperature = temperature;
    }

    public int getTemperature(){
        return temperature;
    }
}
