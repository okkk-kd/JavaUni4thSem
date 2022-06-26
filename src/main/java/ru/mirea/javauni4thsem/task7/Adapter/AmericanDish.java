package ru.mirea.Task7.Adapter;

public class AmericanDish {
    private int fareDegree;
    private int time;

    public AmericanDish(int fareDegree, int time){
        this.fareDegree = fareDegree;
        this.time = time;
    }

    public boolean isCooked(AmericanOven oven){
        return this.fareDegree <= oven.getTemperature();
    }
}
