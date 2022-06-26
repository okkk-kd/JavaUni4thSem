package ru.mirea.Task8.Command;

public class MoveLeft extends Command{

    @Override
    public boolean execute() {
        if (person.x == 0)
            return false;
        else{
            person.x--;
            return true;
        }
    }
}
