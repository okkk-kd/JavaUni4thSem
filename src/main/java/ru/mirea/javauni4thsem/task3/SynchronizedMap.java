package ru.mirea.Task3;

import java.util.*;

public class SynchronizedMap<R,T> implements Map<R,T>{
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    private int size;
    private Node<R, T>[] array;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public synchronized boolean containsKey(Object key) {
        for (int i = 0; i < size; i++) {
            if (array[i].getKey() == key)
                return true;
        }
        return false;
    }

    @Override
    public synchronized boolean containsValue(Object value) {
        for (int i = 0; i < size; i++) {
            if (array[i].getValue() == value)
                return true;
        }
        return false;
    }

    @Override
    public synchronized T get(Object key) {
        for (int i = 0; i < size; i++) {
            if (array[i].getKey() == key)
                return array[i].getValue();
        }
        return null;
    }

    @Override
    public synchronized T put(R key, T value) {
        if ((float) size / array.length >= DEFAULT_LOAD_FACTOR) {
            reSize();
        }
        if (get(key) == null){
            array[size++] = new Node<>(key, value);
            return null;
        }
        else{
            T old = array[getIndex(key)].getValue();
            array[getIndex(key)].setValue(value);
            return old;
        }
    }

    public synchronized int getIndex(R key){
        for (int i = 0; i < size; i++) {
            if (array[i].getKey() == key)
                return i;
        }
        return 0;
    }

    public synchronized void reSize() {
        Node<R, T>[] array2 = new Node[array.length * 2];
        for (int i = 0; i < size; i++) {
            array2[i] = array[i];
        }
        array = array2;
    }

    @Override
    public synchronized T remove(Object key) {
        int j=0;
        boolean flag = false;
        T old = null;
        for (int i = 0; i < size; i++) {
            if (array[i].getKey() == key) {
                flag = true;
                old = array[i].getValue();
                j = i;
                break;
            }
        }
        if(flag){
            for(;j<size-1;j++){
                array[j] = array[j+1];
            }
            array[size-1] = null;
            size--;
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends R, ? extends T> m) {

    }

    @Override
    public synchronized void clear() {
        for(int i=0;i<size;i++){
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public synchronized Set<R> keySet() {
        Set<R> set = new HashSet<>();
        for(int i=0;i<size;i++){
            set.add(array[i].getKey());
        }
        return set;
    }

    @Override
    public synchronized Collection<T> values() {
        Collection<T> collection = new ArrayList<T>();
        for(int i=0;i<size;i++){
            collection.add(array[i].getValue());
        }
        return collection;
    }

    @Override
    public Set<Entry<R, T>> entrySet() {
        return null;
    }

    static class Node<R, T> {
        final R key;
        T value;

        Node(R key, T value) {
            this.key = key;
            this.value = value;
        }

        public final R getKey() {
            return key;
        }

        public final T getValue() {
            return value;
        }

        public final String toString() {
            return key + " = " + value;
        }

        public final T setValue(T newValue) {
            T oldValue = value;
            value = newValue;
            return oldValue;
        }
    }

    SynchronizedMap(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Illegal capacity: " + capacity);
        else {
            array = new Node[capacity];
            size = 0;
        }
    }

}

    /*public synchronized int size() {
        return size;
    }

    public synchronized boolean isEmpty() {
        return size == 0;
    }

    public synchronized T get(R key) {
        for (int i = 0; i < size; i++) {
            if (array[i].getKey() == key)
                return array[i].getValue();
        }
        return null;
    }

    public synchronized void put(R key, T value) {
        if ((float) size / array.length >= DEFAULT_LOAD_FACTOR) {
            reSize();
        }
        if (get(key) == null)
            array[size++] = new Node<>(key,value);
        else{
            array[getIndex(key)].setValue(value);
        }
    }

    public synchronized T remove(R key){
        int j=0;
        boolean flag = false;
        T result = null;
        for (int i = 0; i < size; i++) {
            if (array[i].getKey() == key) {
                j=i;
                result = array[i].getValue();
                flag = true;
                break;
            }
        }
        if(flag){
            for(;j<size-1;j++){
                array[j] = array[j+1];
            }
            array[size-1] = null;
            size--;
        }
        return result;
    }

    public synchronized void clear(){
        for(int i=0;i<size;i++){
            array[i] = null;
        }
        size = 0;
    }*/