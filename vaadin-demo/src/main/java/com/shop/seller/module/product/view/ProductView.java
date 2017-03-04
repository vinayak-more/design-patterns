/**
 * @author Vinayak More
 *
 * @date 04-Mar-2017
 */
package com.shop.seller.module.product.view;

import java.util.List;

import javax.annotation.PostConstruct;

import com.shop.seller.module.product.bean.Product;
import com.shop.uikit.common.uihelper.components.table.TableBuilder;
import com.shop.uikit.common.uihelper.view.AbstractView;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

@UIScope
@SpringView(name = ProductView.NAME)
public class ProductView extends AbstractView<ProductController> {
    public static final String NAME = "products";
    private static final long serialVersionUID = 3327824573305052575L;
    private VerticalLayout layout;
    private TableBuilder<Product> table;

    @PostConstruct
    public void init() {
        layout=new VerticalLayout();
        layout.setSpacing(true);
        layout.setMargin(true);
        table=TableBuilder.createTable(Product.class, "rid","productId","productName","price");
        layout.addComponent(table);
    }


    @Override
    protected Component getComponent() {
        return layout;
    }


    public void setList(List<Product> products) {
       table.setList(products);
    }
    
    

}
