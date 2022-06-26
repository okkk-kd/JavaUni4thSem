package ru.mirea.Task2;

import java.time.LocalDate;

public class Human{
    final int age; // Возраст
    final String firstName; // Имя
    final String lastName; // Фамилия
    final LocalDate birthDate; // Дата рождения
    final int weight; // Вес

    Human(int age, String firstName, String lastName, LocalDate birthDate, int weight){ // Конструктор
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.weight = weight;
    }

    @Override
    public String toString() { // Представление в виде строки
        return firstName + " " + lastName + " (" + birthDate.toString() + ") " + age + " years " + weight + " kg";
    }

}
