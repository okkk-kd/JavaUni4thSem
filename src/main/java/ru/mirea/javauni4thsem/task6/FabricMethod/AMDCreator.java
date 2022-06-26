package ru.mirea.Task6.FabricMethod;

public class AMDCreator extends Creator {
    @Override
    public GPU createGPU() {
        return new AMD_GPU();
    }
}
