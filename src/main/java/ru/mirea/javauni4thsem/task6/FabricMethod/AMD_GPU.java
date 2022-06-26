package ru.mirea.Task6.FabricMethod;

public class AMD_GPU implements GPU {
    @Override
    public void upscale() {
        System.out.println("Turning on FSR.");
    }

    @Override
    public void runGame() {
        System.out.println("Running game with a medium settings.");
    }
}
