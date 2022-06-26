package ru.mirea.Task6.Builder;

public class Director {
    public void constructPowerful(Builder builder){
        builder.setMotherboard(new Motherboard(32, Sockets.AMD));
        builder.setCPU(new CPU(3700,125,8,3200,Sockets.AMD));
        builder.setGPU(new GPU(375,12.8f,12,VideoCard.Nvidia));
        builder.setRAM(new RAM(16,3200));
        builder.setPowerSupply(new PowerSupply(1000));
        builder.setSSDCapacity(2048);
        System.out.println("Created powerful computer");
    }

    public void constructCheap(Builder builder){
        builder.setMotherboard(new Motherboard(16, Sockets.Intel));
        builder.setCPU(new CPU(2400,65,8,2600,Sockets.Intel));
        builder.setGPU(new GPU(175,8.5f,6,VideoCard.AMD));
        builder.setRAM(new RAM(16,3200));
        builder.setPowerSupply(new PowerSupply(600));
        builder.setSSDCapacity(512);
        System.out.println("Created cheap computer");
    }
}
