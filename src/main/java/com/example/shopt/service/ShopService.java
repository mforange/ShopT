package com.example.shopt.service;

import com.example.shopt.dto.ProductDTO;

import java.util.List;

public interface ShopService {

    List<ProductDTO> getProducts();

    List<ProductDTO> getProductById(Integer id_product);

    public void addProduct(ProductDTO product);

}
