package ru.mirea.Task6.Builder;

public class Computer {
    private Motherboard motherboard;
    private CPU cpu;
    private GPU gpu;
    private RAM ram;
    private PowerSupply powerSupply;
    private int SSDCapacity;

    public Computer(Motherboard motherboard, CPU cpu, GPU gpu, RAM ram, PowerSupply powerSupply, int capacity){
        this.cpu = cpu;
        this.gpu = gpu;
        this.motherboard = motherboard;
        this.powerSupply = powerSupply;
        this.ram = ram;
        this.SSDCapacity = capacity;
    }
}
