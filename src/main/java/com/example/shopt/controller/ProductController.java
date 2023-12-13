package com.example.shopt.controller;

import com.example.shopt.dto.ProductDTO;
import com.example.shopt.service.CartService;
import com.example.shopt.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController // вешается на контроллеры, контроллер - класс в котором прописываются рестовые эндпоинты
@RequiredArgsConstructor // создает конструктор для всех полей с модификатором final
@RequestMapping("/product") // смещает все эндпоинты на /product/
public class ProductController {

    private final ShopService shopService;

    @GetMapping("/get-products")
    public List<ProductDTO> getProducts() {
        return shopService.getProducts();
    }

    @GetMapping("/")//@GetMapping//("/{id}")
    public List<ProductDTO> getProductById(@RequestParam("id") Integer id) {
        Integer a = id;
        return shopService.getProductById(id);
    }
}
