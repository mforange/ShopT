package com.example.shopt.dao;

import com.example.shopt.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
// создает бин repository аннотацией (внутри аннотация @Component) - прочитать про отличие Repository, Service
@RequiredArgsConstructor
public class ShopDAOImpl implements ShopDAO {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate; // бин NamedParameterJdbcTemplate, для обращения к базе данных

    @Override
    public List<ProductDTO> getProducts() {
        return namedParameterJdbcTemplate.query("select * from t_products",
                new BeanPropertyRowMapper<>(ProductDTO.class));
    }

    @Override
    public List<ProductDTO> getProductById(Map<String, Object> params) {
        return namedParameterJdbcTemplate.query("select t.* from t_products t where t.id = :id",
                params, new BeanPropertyRowMapper<>(ProductDTO.class));
    }

    @Override
    public void addProduct(ProductDTO product) {
        String sql = "insert into t_products (type, name, price) values (:type, :name, :price)";

        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("type", product.getType())
                .addValue("name", product.getName())
                .addValue("price", product.getPrice());
        namedParameterJdbcTemplate.update(sql, parameters);
    }

//    @Override
//    public void addProduct(Map<String, Object> params) {
//        String sql = "insert into t_products (id, type, name, price) values (:id, :type, :name, :price)";
//        namedParameterJdbcTemplate.update(sql, params);
//    }

}
