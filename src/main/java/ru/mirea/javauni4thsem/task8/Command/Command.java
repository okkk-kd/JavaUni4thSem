package ru.mirea.Task8.Command;

public abstract class Command {
    public Person person;
    public abstract boolean execute();
}
