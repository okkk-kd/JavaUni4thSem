package ru.mirea.Task6.AbstractFactory;

public class Client {
    private AbstractFactory factory;
    private AbstractSmartWatches smartWatches;
    private AbstractPhone phone;

    public Client(AbstractFactory factory){
        this.factory = factory;
    }

    public void buildSetup(String model, int gen){
        this.smartWatches = factory.createSmartWatches(gen);
        this.phone = factory.createPhone(model);
        System.out.println(model + " and " + gen + "th generation watches");
    }
}
