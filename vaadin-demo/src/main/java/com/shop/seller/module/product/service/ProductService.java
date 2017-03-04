/**
 * @author Vinayak More
 *
 * @date 04-Mar-2017
 */
package com.shop.seller.module.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.shop.seller.module.product.bean.Product;
import com.shop.seller.module.product.repositoy.ProductRepository;
import com.vaadin.spring.annotation.SpringComponent;

@SpringComponent
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> getAllProducts(){
        return productRepository.getAllProducts();
    }
}
