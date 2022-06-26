package ru.mirea.Task6;

import ru.mirea.Task6.AbstractFactory.*;
import ru.mirea.Task6.FabricMethod.*;
import ru.mirea.Task6.Builder.*;
import ru.mirea.Task6.Prototype.*;

public class Main {
    public static void main(String args[]){
        AbstractFactory factory1 = new AppleFactory();
        Client client1 = new Client(factory1);
        client1.buildSetup("Iphone 13 Pro", 5);
        AbstractFactory factory2 = new AndroidFactory();
        Client client2 = new Client(factory2);
        client2.buildSetup("Samsung Galaxy S22", 3);
        Creator creator = new NvidiaCreator();
        creator.createGraphicSettings();
        Director director = new Director();
        director.constructPowerful(new ComputerBuilder());
        Client2 client3 = new Client2(new Rectangle(10,5));
        Shape copy = client3.multiply();
    }
}
