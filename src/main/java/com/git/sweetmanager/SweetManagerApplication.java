package com.git.sweetmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@SpringBootApplication
public class SweetManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SweetManagerApplication.class, args);
    }
}
