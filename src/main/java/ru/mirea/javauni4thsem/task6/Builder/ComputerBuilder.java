package ru.mirea.Task6.Builder;

public class ComputerBuilder implements Builder{
    private Motherboard motherboard;
    private CPU cpu;
    private GPU gpu;
    private RAM ram;
    private PowerSupply powerSupply;
    private int SSDCapacity;

    @Override
    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }

    @Override
    public void setCPU(CPU cpu) {
        this.cpu = cpu;
    }

    @Override
    public void setGPU(GPU gpu) {
        this.gpu = gpu;
    }

    @Override
    public void setRAM(RAM ram) {
        this.ram = ram;
    }

    @Override
    public void setPowerSupply(PowerSupply powerSupply) {
        this.powerSupply = powerSupply;
    }

    public void setSSDCapacity(int capacity){
        this.SSDCapacity = capacity;
    }

    public Computer getResult(){
        return new Computer(motherboard,cpu,gpu,ram,powerSupply,SSDCapacity);
    }
}
