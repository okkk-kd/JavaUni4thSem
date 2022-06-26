package ru.mirea.Task3;

import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.function.Consumer;

public class SemaphoreList<T> implements List<T> {
    private int size;
    private Object[] array;
    private static final Semaphore semaphore = new Semaphore(1);

    SemaphoreList(){
        size = 0;
        array = new Object[10];
    }

    SemaphoreList(int x){
        size = 0;
        array = new Object[x];
    }

    public void realloc(int old_s,int new_s){
        Object [] arr1 = new Object[new_s];
        old_s = Math.min(old_s, new_s);
        for(int i=0;i<old_s;i++){
            arr1[i]=array[i];
        }
        array=arr1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        try {
            semaphore.acquire();
            for (int i = 0; i < size; i++) {
                if (array[i] == o){
                    semaphore.release();
                    return true;
                }
            }
            semaphore.release();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        if(size < array.length - 1) {
            try {
                semaphore.acquire();
                array[size++] = t;
                semaphore.release();
                return true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                semaphore.acquire();
                realloc(array.length, array.length*2);
                array[size++] = t;
                semaphore.release();
                return true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if(size != 0) {
            try {
                semaphore.acquire();
                for (int i = 0; i < size; i++) {
                    if (array[i] == o) {
                        for(int j=i;j<size-1;j++){
                            array[j] = array[j+1];
                        }
                        array[size--] = null;
                        semaphore.release();
                        return true;
                    }
                }
                semaphore.release();
                return false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        while(size + c.size() > array.length){
            realloc(size,size*2);
        }
        for(T elem : c){
            array[size++] = elem;
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        try {
            semaphore.acquire();
            while (size + c.size() > array.length) {
                realloc(size, size * 2);
            }
            if(index<size){
                for(int i=size+c.size()-1;i>size-1;i--){
                    array[i] = array[i-c.size()];
                }
                for(T elem : c){
                    array[index++] = elem;
                }
            }
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        for(int i=0;i<size;i++){
            array[i]=0;
        }
        size=0;
    }

    @Override
    public T get(int index) {
        if(index<size) {
            return (T) array[index];
        }
        return null;
    }

    @Override
    public T set(int index, T element) {
        if(size != 0 && index<size) {
            try {
                semaphore.acquire();
                T old = (T)array[index];
                array[index] = element;
                semaphore.release();
                return old;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void add(int index, T element) {
        if(size != 0 && index<size) {
            try {
                semaphore.acquire();
                for(int i=size;i>index;i--){
                    array[i] = array[i-1];
                }
                array[index] = element;
                size++;
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public T remove(int index) {
        if(size != 0 && index<size) {
            try {
                semaphore.acquire();
                T old = (T)array[index];
                for(int j=index;j<size;j++){
                    array[j] = array[j+1];
                }
                array[size--] = null;
                semaphore.release();
                return old;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        if(size != 0) {
            try {
                semaphore.acquire();
                for (int i = 0; i < size; i++) {
                    if (array[i] == o){
                        semaphore.release();
                        return i;
                    }
                }
                semaphore.release();
                return -1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if(size != 0) {
            try {
                semaphore.acquire();
                int result = 0;
                for (int i = 0; i < size; i++) {
                    if (array[i] == o){
                        result = i;
                    }
                }
                semaphore.release();
                return result;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        List.super.forEach(action);
    }
}
