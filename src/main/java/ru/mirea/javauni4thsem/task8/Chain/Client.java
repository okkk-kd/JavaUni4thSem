package ru.mirea.Task8.Chain;

public class Client {
    Checker checker;
    int index;
    String INN;

    public Client(Checker checker, int index, String INN){
        this.checker = checker;
        this.index = index;
        this.INN = INN;
    }

    public boolean startChecking(){
        return checker.check(index, INN);
    }
}
