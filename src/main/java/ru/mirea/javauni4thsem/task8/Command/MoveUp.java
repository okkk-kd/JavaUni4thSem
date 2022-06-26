package ru.mirea.Task8.Command;

public class MoveUp extends Command{

    @Override
    public boolean execute() {
        if (person.y == 0)
            return false;
        else{
            person.y--;
            return true;
        }
    }
}
