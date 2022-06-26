package ru.mirea.Task6.Builder;

public class Motherboard {
    private int maxRAM;
    private Sockets socket;

    public Motherboard(int maxRAM, Sockets socket){
        this.maxRAM = maxRAM;
        this.socket = socket;
    }

    public int getMaxRAM() {
        return maxRAM;
    }
}
