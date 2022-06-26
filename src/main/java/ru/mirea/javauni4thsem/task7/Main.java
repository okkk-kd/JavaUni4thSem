package ru.mirea.Task7;

import ru.mirea.Task7.Bridge.*;
import ru.mirea.Task7.Adapter.*;

public class Main {
    public static void main(String args[]){
        Device device = new Generator(220);
        Switch switcher = new Switch(device);
        System.out.println(device.isTurned());
        switcher.switchDevice();
        System.out.println(device.isTurned());
        AmericanDish dish = new AmericanDish(320,45);
        EuropeanOven oven = new EuropeanOven(150);
        OvenAdapter adapter = new OvenAdapter(oven);
        System.out.println(dish.isCooked(adapter));
    }
}
