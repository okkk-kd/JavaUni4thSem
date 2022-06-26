package ru.mirea.Task8.Command;

public class MoveDown extends Command{

    @Override
    public boolean execute() {
        if (person.y == 200)
            return false;
        else{
            person.y++;
            return true;
        }
    }
}
