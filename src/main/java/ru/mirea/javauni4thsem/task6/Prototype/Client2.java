package ru.mirea.Task6.Prototype;

public class Client2 {
    private Shape shape;

    public Client2(Shape shape){
        this.shape = shape;
    }

    public Shape multiply(){
        return shape.clone();
    }
}
