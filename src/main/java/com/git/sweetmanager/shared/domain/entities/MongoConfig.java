package com.git.sweetmanager.shared.domain.entities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {

    @Bean
    public ModelListener modelListener() {
        return new ModelListener();
    }
}
