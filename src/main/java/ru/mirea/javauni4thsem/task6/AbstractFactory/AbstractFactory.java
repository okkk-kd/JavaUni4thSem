package ru.mirea.Task6.AbstractFactory;

public interface AbstractFactory {
    AbstractSmartWatches createSmartWatches(int gen);
    AbstractPhone createPhone(String model);
}
