package com.example.shopt.dao;

import com.example.shopt.dto.ProductDTO;

import java.util.List;
import java.util.Map;

public interface ShopDAO {

    List<ProductDTO> getProducts();

    List<ProductDTO> getProductById(Map<String, Object> params);
}
