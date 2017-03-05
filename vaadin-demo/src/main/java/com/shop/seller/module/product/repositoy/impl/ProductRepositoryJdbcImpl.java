/**
 * @author Vinayak More
 *
 * @date 04-Mar-2017
 */
package com.shop.seller.module.product.repositoy.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
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


    @Override
    public boolean updateProduct(Product bean) {
        boolean isSucess = true;
        try {
            String query = "UPDATE product set product_id=?,name=?,price=? WHERE rid=?";

            int rowsAffected = jdbcTemplate.update(query, new PreparedStatementSetter() {

                @Override
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setString(1, bean.getProductId());
                    ps.setString(2, bean.getProductName());
                    ps.setDouble(3, bean.getPrice());
                    ps.setInt(4, bean.getRid());
                }
            });
            isSucess = rowsAffected > 0;
        } catch (Exception e) {
            logger.error("Exception in Update Product", e);
            isSucess = false;
        }
        return isSucess;
    }


    @Override
    public boolean saveProduct(Product bean) {
        boolean isSucess = true;
        try {
            String query = "INSERT INTO product (product_id,name,price) values (?,?,?)";
            jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

                @Override
                public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                    ps.setString(1, bean.getProductId());
                    ps.setString(2, bean.getProductName());
                    ps.setDouble(3, bean.getPrice());
                    return ps.execute();
                }
            });
        } catch (Exception e) {
            logger.error("Exception in Save Product", e);
            e.printStackTrace();
            isSucess = false;
        }
        return isSucess;
    }


}
