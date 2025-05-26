package com.buymore;

import com.buymore.buymore.*;
import com.buymore.cia.*;
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