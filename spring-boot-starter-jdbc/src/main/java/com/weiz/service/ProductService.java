package com.weiz.service;

import com.weiz.pojo.Product;
import org.springframework.jdbc.core.JdbcTemplate;

public interface ProductService {
    int save(Product product, JdbcTemplate jdbcTemplate);

    int update(Product product,JdbcTemplate jdbcTemplate);

    int delete(long id,JdbcTemplate jdbcTemplate);

    Product findById(long id,JdbcTemplate jdbcTemplate);
}

