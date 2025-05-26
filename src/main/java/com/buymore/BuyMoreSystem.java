package com.buymore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.time.LocalDateTime;
@SpringBootApplication
@EnableCaching
public class BuyMoreSystem {
    public static void main(String[] args) {
        SpringApplication.run(BuyMoreSystem.class, args);

    }


}