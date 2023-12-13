package com.example.shopt.configuration;

import com.example.shopt.dao.ShopDAO;
import com.example.shopt.service.CartService;
import com.example.shopt.service.CartServiceImpl;
import com.example.shopt.service.ShopService;
import com.example.shopt.service.ShopServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShopTConfiguration {

    @Bean // создаем бин сервиса BotyaService (один из вариантов, можно также повесить в сервисе аннотацию @Service)
    public ShopService shopService(ShopDAO repository) {
        return new ShopServiceImpl(repository);
    }


}
