package ru.mirea.Task8.Chain;

public class INNChecker extends Checker{

    @Override
    public boolean check(int index, String INN) {
        int[] k1 = {7,2,4,10,3,5,9,4,6,8};
        int[] k2 = {3,7,2,4,10,3,5,9,4,6,8};
        try{
            long x = Long.parseLong(INN);
        }
        catch (NumberFormatException e ) {
            e.printStackTrace();
        }
        String[] inn = INN.split("");
        int n1 = 0, n2 = 0;
        for (int i = 0; i < 10; i++) {
            n1 += k1[i] * Integer.parseInt(inn[i]);
        }
        n1 %= 11;
        n1 %= 10;
        if (n1 != Integer.parseInt(inn[10])) {
            return false;
        }else{
            for (int i = 0; i < 11; i++) {
                n2 += k2[i] * Integer.parseInt(inn[i]);
            }
            n2 %= 11;
            n2 %= 10;
            if (n2 != Integer.parseInt(inn[11])) {
                return false;
            } else {
                return checkNext(index, INN);
            }
        }
    }
}
