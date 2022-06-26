package ru.mirea.Task6.AbstractFactory;

public class AppleFactory implements AbstractFactory{

    @Override
    public AbstractPhone createPhone(String model) {
        return new ApplePhone(model);
    }

    @Override
    public AbstractSmartWatches createSmartWatches(int gen) {
        return new AppleSmartWatches(gen);
    }
}
