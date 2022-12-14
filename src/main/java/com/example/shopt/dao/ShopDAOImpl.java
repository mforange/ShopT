package com.example.shopt.dao;

import com.example.shopt.dto.CartDTO;
import com.example.shopt.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // создает бин repository аннотацией (внутри аннотация @Component) - прочитать про отличие Repository, Service
@RequiredArgsConstructor
public class ShopDAOImpl implements ShopDAO {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate; // бин NamedParameterJdbcTemplate, для обращения к базе данных

    @Override
    public List<ProductDTO> getProducts() {
        return namedParameterJdbcTemplate.query("select * from t_products", new BeanPropertyRowMapper<>(ProductDTO.class));
    }

    @Override
    public List<ProductDTO> getProductById(Integer id_product){
        return namedParameterJdbcTemplate.query("select t.* from t_products t where t.id = :id", new BeanPropertyRowMapper<>(ProductDTO.class));
    }

}
