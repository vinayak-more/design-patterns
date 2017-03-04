/**
 * @author Vinayak More
 *
 * @date 04-Mar-2017
 */
package com.example.product;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shop.boot.JavaConfiguration;
import com.shop.seller.module.product.repositoy.ProductRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JavaConfiguration.class})
public class ProductRepoTest {

    @Autowired
    ProductRepository productRepository;
    
    @Test
    public void shouldNotBeNull(){
        Assert.assertNotNull(productRepository);
    }
    
    @Test
    public void productListshouldNotBeNull(){
        Assert.assertNotNull(productRepository.getAllProducts());
    }
}
