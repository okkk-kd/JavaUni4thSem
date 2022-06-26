package ru.mirea.Task5;

public class Singleton_3 {
    private Singleton_3(){}
    private static class SingletonHolder {
        public static final Singleton_3 INSTANCE = new Singleton_3();
    }

    public static Singleton_3 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
