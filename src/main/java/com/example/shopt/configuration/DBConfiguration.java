package com.example.shopt.configuration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBConfiguration {
    @Bean
    @ConfigurationProperties("spring.datasource.hikari") // внедряет все настройки из application.properties которые начинаются на spring.datasource.hikari
    public HikariDataSource hikariDataSource() {
        return new HikariDataSource();
    }

}
