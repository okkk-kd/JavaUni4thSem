package ru.mirea.Task6.Prototype;

public class Rectangle implements Shape {
    private int width;
    private int height;
    public Rectangle(){

    }
    public Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }
    Rectangle(Rectangle target){
        if(target != null){
            this.height = target.height;
            this.width = target.width;
        }
    }

    @Override
    public Shape clone() {
        System.out.println("Copy a rectangle");
        return new Rectangle(this);
    }
}
