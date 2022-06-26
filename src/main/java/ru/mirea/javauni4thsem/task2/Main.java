package ru.mirea.Task2;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String args[]){
        List<Human> humans = new ArrayList<Human>(); // Список объектов класса Human
        long minDay = LocalDate.of(1970, 1, 1).toEpochDay(); // Минимальная дата рождения
        long maxDay = LocalDate.of(2020, 12, 31).toEpochDay(); // Максимальная дата рождения
        for(int i = 0;i < 8;i++){ // Заполнение списка объектами со случайными полями
            int weight = (int) (Math.random() * 100); // Случайный вес
            long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay); // Случайный день рождения
            LocalDate birthDate = LocalDate.ofEpochDay(randomDay);
            long dif = maxDay - randomDay;
            int age = (int) Math.round(dif/365.0); // Возраст человека
            int name = (int) Math.round(Math.random() * 10); // Случайный номер для определения имени
            String firstName = ""; // Строка имени
            switch (name){ // Свич номера для определения случайного имени
                case 0:
                    firstName = "Joe";
                    break;
                case 1:
                    firstName = "Tom";
                    break;
                case 2:
                    firstName = "Kevin";
                    break;
                case 3:
                    firstName = "Bruce";
                    break;
                case 4:
                    firstName = "Marcus";
                    break;
                case 5:
                    firstName = "Andrew";
                    break;
                case 6:
                    firstName = "John";
                    break;
                case 7:
                    firstName = "Chris";
                    break;
                case 8:
                    firstName = "David";
                    break;
                case 9:
                    firstName = "Paul";
                    break;
                case 10:
                    firstName = "Ethan";
                    break;
            }
            name = (int) Math.round(Math.random() * 10);
            String secondName = ""; // Строка фамилии
            switch (name){ // Свич номера для определения случайной фамилии
                case 0:
                    secondName = "Brown";
                    break;
                case 1:
                    secondName = "Harris";
                    break;
                case 2:
                    secondName = "Porter";
                    break;
                case 3:
                    secondName = "Green";
                    break;
                case 4:
                    secondName = "Miller";
                    break;
                case 5:
                    secondName = "Richards";
                    break;
                case 6:
                    secondName = "White";
                    break;
                case 7:
                    secondName = "Towns";
                    break;
                case 8:
                    secondName = "Grant";
                    break;
                case 9:
                    secondName = "Murray";
                    break;
                case 10:
                    secondName = "Lewis";
                    break;
            }
            humans.add(new Human(age, firstName, secondName, birthDate, weight)); // Добавляем в список новый объект с созданными полями
        }
        LocalDate filterDate = LocalDate.of(2000, 6, 24); // Дата для фильтрации
        Stream<Human> stream = humans.stream(); // Поток из списка
        stream.sorted(new NameComparator()) // Сортировка по именам и вывод на экран
                .forEach(System.out::println);
        System.out.println();
        humans.stream().filter(human -> human.birthDate.isAfter(filterDate)) // Фильтрация по дате рождения
                .forEach(System.out::println);
        System.out.println();
        humans.stream().sorted(new LastNameComparator()) // Сортировка по фамилиям и вывод на экран
                .forEach(System.out::println);
        int totalAge = humans.stream().mapToInt(human -> human.age).sum(); // Создание целочисленного потока из возрастов
        // объектов потока humans и нахождение суммы элементов этого целочисленного потока
        System.out.println();
        System.out.println(totalAge + " years");
    }
}
class NameComparator implements Comparator<Human>{ // Компаратор для имен
    public int compare(Human a, Human b){
        return a.firstName.toUpperCase().compareTo(b.firstName.toUpperCase());
    }
}
class LastNameComparator implements Comparator<Human>{ // Компаратор для фамилий
    public int compare(Human a, Human b){
        return a.lastName.toUpperCase().compareTo(b.lastName.toUpperCase());
    }
}