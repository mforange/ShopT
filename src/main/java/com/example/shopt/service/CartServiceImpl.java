package com.example.shopt.service;

import com.example.shopt.dao.ShopDAO;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
public class CartServiceImpl implements CartService{

    private HashMap<Integer, Integer> cart;
    private Float price;
    private final ShopDAO shopdao;

    @Override
    public boolean addToCart(Integer id_product, Integer qnty_product) {
        cart.put(id_product, qnty_product);
        return true;
        // = shopService.getProductById(id_product)
    }

    @Override
    public HashMap<Integer, Integer> getCart() {
        return cart;
    }

}
