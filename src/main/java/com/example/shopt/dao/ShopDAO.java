package com.example.shopt.dao;

import com.example.shopt.dto.ProductDTO;

import java.util.List;

public interface ShopDAO {

    List<ProductDTO> getProducts();

    List<ProductDTO> getProductById(Integer id);


}
