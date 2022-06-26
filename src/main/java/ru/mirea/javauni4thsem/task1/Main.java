package ru.mirea.Task1;

import java.util.*;
import java.util.function.*;

public class Main {
    public static void quickSort(Integer[] array, int low, int high) {
        if (array.length == 0)
            return;//завершить выполнение, если длина массива равна 0
        if (low >= high)
            return;//завершить выполнение если уже нечего делить
        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        Integer center = array[middle];
        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < center) {
                i++;
            }
            while (array[j] > center) {
                j--;
            }
            if (i <= j) {//меняем местами
                Integer temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);
        if (high > i)
            quickSort(array, i, high);
    }
    public static void main(String args[]){
        Function<Integer[],String> minValue = (arr) ->{
            quickSort(arr,0,arr.length-1); // Сортируем массив
            StringBuilder result = new StringBuilder(); // Строка - результат
            int i=0;
            while(arr[i] == 0){ // Находим индекс первого элемента массива, не равного нулю
                i++;
            }
            if(i==0){ // Если в массиве нет нулей
                result.append(arr[i]); // Добавляем первую цифру в строку
                i++;
                for(;i<arr.length;i++){ // Проходим по всему массиву
                    if(arr[i] != arr[i - 1]) // Если очередной элемент еще не встречался в массиве
                        result.append(arr[i]); // Добавляем очередную цифру в массив
                }
            }
            else{ // Иначе
                result.append(arr[i]); // Добавляем первую цифру в строку
                result.append(arr[i-1]); // Далее добавляем 0
                i++;
                for(;i<arr.length;i++){ // Проходим по массиву
                    if(arr[i] != arr[i - 1]) // Если очередной элемент еще не встречался в массиве
                        result.append(arr[i]); // Добавляем очередную цифру в массив
                }
            }
            return result.toString(); // Возвращаем строку-результат
        };
        Integer []array = {1, 3, 1, 4, 0}; // Создаем массив
        System.out.println(minValue.apply(array)); // Вызываем функцию
    }
}
