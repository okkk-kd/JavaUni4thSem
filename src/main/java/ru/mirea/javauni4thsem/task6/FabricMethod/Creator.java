package ru.mirea.Task6.FabricMethod;

public abstract class Creator {
    public void createGraphicSettings(){
        GPU gpu = createGPU();
        gpu.upscale();
        gpu.runGame();
    }
    public abstract GPU createGPU();
}
