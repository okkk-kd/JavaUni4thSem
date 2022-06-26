package ru.mirea.Task8.Chain;

public class IndexChecker extends Checker{

    @Override
    public boolean check(int index, String INN) {
        int temp = index, count = 0;
        while (temp > 0){
            count++;
            temp /= 10;
        }
        if (count == 6)
            return checkNext(index, INN);
        else
            return false;
    }
}
