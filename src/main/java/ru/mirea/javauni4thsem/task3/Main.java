package ru.mirea.Task3;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String args[]) throws Exception{
        List<Integer> sema = new SemaphoreList<>();
        SynchronizedMap<String,Integer> map = new SynchronizedMap<>(10);
        Thread one = new Thread(()->{
            map.put("lol",12);
            for(int i=0;i<6;i++){
                sema.add(i);
            }
            map.put("lol",13);
        });
        Thread two = new Thread(()->{
            map.put("lol",14);
            for(int i=0;i<11;i++){
                sema.add(i);
            }
            map.put("lol",15);
        });
        one.start();
        two.start();
        Thread.sleep(3000);
        System.out.println(Arrays.toString(sema.toArray()));
        System.out.println(map.get("lol"));
    }
}
