package com.weiz.service.impl;

import com.weiz.pojo.Product;
import com.weiz.service.ProductService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService  {
    @Override
    public int save(Product product,JdbcTemplate jdbcTemplate) {
        return jdbcTemplate.update("INSERT INTO products(name, code, price) values(?, ? , ?)",
                product.getName(), product.getCode(), product.getPrice());
    }

    @Override
    public int update(Product product,JdbcTemplate jdbcTemplate) {
        return jdbcTemplate.update("UPDATE products SET name = ? , code = ? , price = ? WHERE id=?",
                product.getName(), product.getCode(), product.getPrice(), product.getId());
    }

    @Override
    public int delete(long id,JdbcTemplate jdbcTemplate) {
        return jdbcTemplate.update("DELETE FROM products where id = ? ",id);
    }

    @Override
    public Product findById(long id,JdbcTemplate jdbcTemplate) {
        return jdbcTemplate.queryForObject("SELECT * FROM products WHERE id=?", new Object[] { id }, new BeanPropertyRowMapper<Product>(Product.class));
    }

}
