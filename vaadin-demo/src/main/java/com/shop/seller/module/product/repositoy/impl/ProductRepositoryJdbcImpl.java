/**
 * @author Vinayak More
 *
 * @date 04-Mar-2017
 */
package com.shop.seller.module.product.repositoy.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.shop.seller.module.product.bean.Product;
import com.shop.seller.module.product.repositoy.ProductRepository;
import com.vaadin.spring.annotation.SpringComponent;

@SpringComponent
public class ProductRepositoryJdbcImpl implements ProductRepository {


    private static final Logger logger = LoggerFactory.getLogger(ProductRepositoryJdbcImpl.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<Product>();
        try {
            String query = "select * from product";
            productList = jdbcTemplate.query(query, new RowMapper<Product>() {

                @Override
                public Product mapRow(ResultSet rs, int rowNumber) throws SQLException {
                    Product product = new Product();
                    product.setRid(rs.getInt("rid"));
                    product.setProductId(rs.getString("product_id"));
                    product.setProductName(rs.getString("name"));
                    product.setPrice(rs.getDouble("price"));
                    return product;
                }
            });
        } catch (Exception e) {
            logger.error("Exception in ProductRepository.getAllProducts", e);
        }
        return productList;
    }


}
