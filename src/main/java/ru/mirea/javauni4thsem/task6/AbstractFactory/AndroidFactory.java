package ru.mirea.Task6.AbstractFactory;

public class AndroidFactory implements AbstractFactory{
    @Override
    public AbstractSmartWatches createSmartWatches(int gen) {
        return new AndroidSmartWatches(gen);
    }

    @Override
    public AbstractPhone createPhone(String model) {
        return new AndroidPhone(model);
    }
}
