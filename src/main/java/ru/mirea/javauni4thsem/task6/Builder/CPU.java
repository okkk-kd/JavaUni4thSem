package ru.mirea.Task6.Builder;

public class CPU {
    private int clockSpeed;
    private int TDP;
    private int cores;
    private int supportingRAM;
    private Sockets firm;

    public CPU(int clockSpeed, int TDP, int cores, int supportingRAM, Sockets firm){
        this.clockSpeed = clockSpeed;
        this.cores = cores;
        this.TDP = TDP;
        this.supportingRAM = supportingRAM;
        this.firm = firm;
    }

    public int getTDP() {
        return TDP;
    }

    public int getSupportingRAM() {
        return supportingRAM;
    }
}
