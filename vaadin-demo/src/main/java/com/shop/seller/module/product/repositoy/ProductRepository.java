/**
 * @author Vinayak More
 *
 * @date 04-Mar-2017
 */
package com.shop.seller.module.product.repositoy;

import java.util.List;

import com.shop.seller.module.product.bean.Product;

public interface ProductRepository {
    
    public List<Product> getAllProducts();

    public boolean updateProduct(Product bean);

    public boolean saveProduct(Product bean);

}
