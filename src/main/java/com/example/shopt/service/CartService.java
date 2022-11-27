package com.example.shopt.service;

import java.util.HashMap;
import java.util.List;

public interface CartService {

    boolean addToCart(Integer id, Integer qnty);

    HashMap<Integer, Integer> getCart();

}
