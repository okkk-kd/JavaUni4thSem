package ru.mirea.Task6.Builder;

public interface Builder {
    void setMotherboard(Motherboard motherboard);
    void setCPU(CPU cpu);
    void setGPU(GPU gpu);
    void setRAM(RAM ram);
    void setPowerSupply(PowerSupply powerSupply);
    void setSSDCapacity(int capacity);
}
