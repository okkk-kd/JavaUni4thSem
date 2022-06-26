package com;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Task10Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        StrongKnight strongKnight = context.getBean(StrongKnight.class);
        strongKnight.fight();
        WeakKnight weakKnight = context.getBean(WeakKnight.class);
        weakKnight.fight();
        KingOfKnights king = context.getBean(KingOfKnights.class);
        king.fight();
    }
}

