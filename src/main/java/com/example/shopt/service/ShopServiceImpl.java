package com.example.shopt.service;

import com.example.shopt.dao.ShopDAO;
import com.example.shopt.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {

    private final ShopDAO shopdao;

    public List<ProductDTO> getProducts(){
        return shopdao.getProducts();
    }

    public List<ProductDTO> getProductById(Integer id_product){
        Map<String, Object> params = new HashMap<>();
        params.put("id", id_product);
        return shopdao.getProductById(params);
    }

//    public void addProduct(ProductDTO product){
//       Map<String, Object> params = new HashMap<>();
//       product.
//    }

    public void addProduct(ProductDTO product){
        shopdao.addProduct(product);
    }


}
