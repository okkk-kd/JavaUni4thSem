package ru.mirea.Task6.Prototype;

public class Circle implements Shape {
    private int radius;
    public Circle(){

    }
    public Circle(int radius){
        this.radius = radius;
    }
    public Circle(Circle target){
        if(target != null){
            this.radius = target.radius;
        }
    }

    @Override
    public Shape clone() {
        System.out.println("Copy a circle");
        return new Circle(this);
    }
}
