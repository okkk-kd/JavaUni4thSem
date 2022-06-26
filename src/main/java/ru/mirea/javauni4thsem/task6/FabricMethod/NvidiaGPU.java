package ru.mirea.Task6.FabricMethod;

public class NvidiaGPU implements GPU{

    @Override
    public void upscale() {
        System.out.println("Turning on DLSS.");
    }

    @Override
    public void runGame() {
        System.out.println("Running game with a high settings.");
    }
}
