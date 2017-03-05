/**
 * @author Vinayak More
 *
 * @date 05-Mar-2017
 */
package com.shop.seller.module.product.view.event;

import com.shop.seller.module.product.bean.Product;

public class SaveProductEvent {

    private Product bean;

    public SaveProductEvent(Product bean) {
        this.bean = bean;
    }

    public Product getBean() {
        return bean;
    }

}
