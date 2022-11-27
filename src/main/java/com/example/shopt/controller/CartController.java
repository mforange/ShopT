package com.example.shopt.controller;

import com.example.shopt.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController // вешается на контроллеры, контроллер - класс в котором прописываются рестовые эндпоинты
@RequiredArgsConstructor // создает конструктор для всех полей с модификатором final
public class CartController {

    private final CartService cartService;

    @PostMapping("/add-to-cart")
    public boolean addToCart(Integer id, Integer qnty) {
        return cartService.addToCart(id, qnty);
    }

    @GetMapping("/get-cart")
    public HashMap<Integer, Integer> getCart() {
        return cartService.getCart();
    }

}
