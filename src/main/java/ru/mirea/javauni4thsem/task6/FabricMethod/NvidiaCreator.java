package ru.mirea.Task6.FabricMethod;

public class NvidiaCreator extends Creator {
    @Override
    public GPU createGPU() {
        return new NvidiaGPU();
    }
}
