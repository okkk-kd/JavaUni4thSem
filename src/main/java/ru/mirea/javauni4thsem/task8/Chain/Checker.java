package ru.mirea.Task8.Chain;

public abstract class Checker {
    private Checker next;

    /**
     * Помогает строить цепь из объектов-проверок.
     */
    public Checker linkWith(Checker next) {
        this.next = next;
        return next;
    }

    public abstract boolean check(int index,String INN);

    protected boolean checkNext(int index,String INN) {
        if (next == null) {
            return true;
        }
        return next.check(index, INN);
    }
}
