package ru.mirea.Task8;

import ru.mirea.Task8.Chain.*;
import ru.mirea.Task8.Command.*;

public class Main {
    public static void main(String []args){
        Checker checker = new IndexChecker();
        checker.linkWith(new INNChecker());
        Client client = new Client(checker,403785,"526317984689");
        System.out.println(client.startChecking());

    }
}
