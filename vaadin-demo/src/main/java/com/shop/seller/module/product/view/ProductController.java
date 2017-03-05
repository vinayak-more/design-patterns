/**
 * @author Vinayak More
 *
 * @date 04-Mar-2017
 */
package com.shop.seller.module.product.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;

import com.shop.seller.module.product.delegate.ProductDelegate;
import com.shop.seller.module.product.view.event.SaveProductEvent;
import com.shop.uikit.common.uihelper.view.AbstractController;
import com.vaadin.spring.annotation.SpringComponent;

@SpringComponent
public class ProductController extends AbstractController<ProductView> {

    @Autowired
    ProductDelegate delegate;

    @Override
    public void onViewEnter() {
        getView().setList(delegate.getAllProduct());
    }
    
    @EventListener
    public void onSaveProductEvent(SaveProductEvent event){
        System.out.println("ProductController.onSaveProductEvent()"+event.getBean());
        boolean isSucess=delegate.saveProduct(event.getBean());
        getView().setSucess(isSucess);
        getView().setList(delegate.getAllProduct());
    }

}
