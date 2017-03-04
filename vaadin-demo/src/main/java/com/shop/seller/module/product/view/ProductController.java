/**
 * @author Vinayak More
 *
 * @date 04-Mar-2017
 */
package com.shop.seller.module.product.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.shop.seller.module.product.bean.Product;
import com.shop.seller.module.product.delegate.ProductDelegate;
import com.shop.uikit.common.uihelper.view.AbstractController;
import com.vaadin.spring.annotation.SpringComponent;

@SpringComponent
public class ProductController extends AbstractController<ProductView> {

    @Autowired
    ProductDelegate delegate;

    @Override
    public void onViewEnter() {
        List<Product> products=delegate.getAllProduct();
        getView().setList(products);
    }

}
