package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public StrongKnight strongKnight() {
        return new StrongKnight();
    }

    @Bean
    public WeakKnight weakKnight() {
        return new WeakKnight();
    }

    @Bean
    public KingOfKnights king() {
        return new KingOfKnights();
    }
}