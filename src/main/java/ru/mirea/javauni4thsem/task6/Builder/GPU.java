package ru.mirea.Task6.Builder;

public class GPU {
    private int TDP;
    private float TFlops;
    private int videoRAM;
    private VideoCard brand;

    public GPU(int TDP, float TFlops, int videoRAM, VideoCard brand){
        this.TDP = TDP;
        this.TFlops = TFlops;
        this.videoRAM = videoRAM;
        this.brand = brand;
    }

    public int getTDP(){
        return this.TDP;
    }
}
