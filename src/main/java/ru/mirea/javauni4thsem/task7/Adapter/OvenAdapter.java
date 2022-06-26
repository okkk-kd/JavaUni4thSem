package ru.mirea.Task7.Adapter;

public class OvenAdapter extends AmericanOven{
    private EuropeanOven oven;

    public OvenAdapter(EuropeanOven oven) {
        this.oven = oven;
    }

    @Override
    public int getTemperature() {
        return (int) Math.round(oven.getTemperature() * 1.8 + 32);
    }
}
