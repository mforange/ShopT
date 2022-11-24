package com.example.shopt.configuration;

import com.example.shopt.dao.ShopDAO;
import com.example.shopt.dao.ShopDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShopTConfiguration {

    @Bean // создаем бин сервиса BotyaService (один из вариантов, можно также повесить в сервисе аннотацию @Service)
    public ShopDAO botyaService(ShopDAO repository) {
        return new ShopDAOImpl(repository);
    }
}
