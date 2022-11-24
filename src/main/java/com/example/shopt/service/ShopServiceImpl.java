package com.example.shopt.service;

import com.example.shopt.dao.ShopDAO;
import com.example.shopt.dto.ProductDTO;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {

    private final ShopDAO shopdao;

    public List<ProductDTO> getProducts(){
        return shopdao.getProducts();
    }


}
