package com.example.shopt.dao;

import com.example.shopt.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
// создает бин repository аннотацией (внутри аннотация @Component) - прочитать про отличие Repository, Service
@RequiredArgsConstructor
public class ShopDAOImpl implements ShopDAO {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate; // бин NamedParameterJdbcTemplate, для обращения к базе данных

    @Override
    public List<ProductDTO> getProducts() {
        return namedParameterJdbcTemplate.query("select * from t_products", new BeanPropertyRowMapper<>(ProductDTO.class));
    }

    @Override
    public List<ProductDTO> getProductById(Map<String, Object> params) {
        return namedParameterJdbcTemplate.query("select t.* from t_products t where t.id = :id", params, new BeanPropertyRowMapper<>(ProductDTO.class));
    }
}
