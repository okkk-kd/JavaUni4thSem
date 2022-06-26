package ru.mirea.Task6.AbstractFactory;

public class AndroidPhone implements AbstractPhone {
    String model;

    AndroidPhone(String model){
        this.model = model;
    }
}
