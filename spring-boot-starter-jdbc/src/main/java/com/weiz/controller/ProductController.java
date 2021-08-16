package com.weiz.controller;

import com.weiz.pojo.Product;
import com.weiz.service.ProductService;
import com.weiz.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private JdbcTemplate primaryJdbcTemplate;
    @Autowired
    private JdbcTemplate secondaryJdbcTemplate;

    @RequestMapping("/save")
    public JSONResult save() {
        Product product = new Product();
        product.setCode("iphone 11");
        product.setName("iphone 11");
        product.setPrice(100);
        productService.save(product,primaryJdbcTemplate);
        productService.save(product,secondaryJdbcTemplate);
        return JSONResult.ok("保存成功");
    }

    @RequestMapping("/update")
    public JSONResult update() {
        long pid = 1;
        Product product = new Product();
        product.setCode("iphone 12");
        product.setName("iphone 12");
        product.setPrice(200);
        product.setId(pid);
        productService.update(product,primaryJdbcTemplate);
        productService.update(product,secondaryJdbcTemplate);
        return JSONResult.ok("修改成功");
    }

    @RequestMapping("/delete")
    public JSONResult delete(long pid) {
        productService.delete(pid,primaryJdbcTemplate);
        productService.delete(pid,secondaryJdbcTemplate);
        return JSONResult.ok("删除成功");
    }

    @RequestMapping("/findbyId")
    public JSONResult findById(long pid) {
        productService.findById(pid,primaryJdbcTemplate);
        Product product =  productService.findById(pid,secondaryJdbcTemplate);
        return JSONResult.ok(product);
    }
}