/**
 * @author Vinayak More
 *
 * @date 04-Mar-2017
 */
package com.shop.seller.module.product.delegate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.shop.seller.module.product.bean.Product;
import com.shop.seller.module.product.service.ProductService;
import com.vaadin.spring.annotation.SpringComponent;

@SpringComponent
public class ProductDelegate {

    @Autowired
    private ProductService service;
    
    public List<Product> getAllProduct(){
        return service.getAllProducts();
    }
}
