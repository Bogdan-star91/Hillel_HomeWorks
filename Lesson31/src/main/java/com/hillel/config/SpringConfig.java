package com.hillel.config;

import com.hillel.service.impl.CacheImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean(name = "CacheImpl")
    public CacheImpl getHelloWorld() {
        return new CacheImpl();
    }
}
