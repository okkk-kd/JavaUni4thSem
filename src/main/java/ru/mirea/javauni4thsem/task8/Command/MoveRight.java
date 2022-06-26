package ru.mirea.Task8.Command;

public class MoveRight extends Command{

    @Override
    public boolean execute() {
        if (person.x == 200)
            return false;
        else{
            person.x++;
            return true;
        }
    }
}
