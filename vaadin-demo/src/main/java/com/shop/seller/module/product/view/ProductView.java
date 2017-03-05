/**
 * @author Vinayak More
 *
 * @date 04-Mar-2017
 */
package com.shop.seller.module.product.view;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.shop.seller.module.product.bean.Product;
import com.shop.uikit.common.uihelper.components.table.TableBuilder;
import com.shop.uikit.common.uihelper.view.AbstractView;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@UIScope
@SpringView(name = ProductView.NAME)
public class ProductView extends AbstractView<ProductController> {
    public static final String NAME = "products";
    private static final long serialVersionUID = 3327824573305052575L;
    private VerticalLayout layout;
    private Button add;
    private TableBuilder<Product> table;

    @Autowired
    ProductWindow productWindow;

    @PostConstruct
    public void init() {
        layout = new VerticalLayout();
        layout.setSpacing(true);
        layout.setMargin(true);
        initTable();
        initButton();
        layout.addComponent(add);
        layout.addComponent(table);
    }



    private void initTable() {
        table = TableBuilder.createTable(Product.class, "rid", "productId", "productName", "price");
        table.setHeaders("Rid","Product Id","Product Name","Price");
        table.getVaadinTable().addValueChangeListener(new ValueChangeListener() {

            private static final long serialVersionUID = -8771564466308883528L;

            @Override
            public void valueChange(ValueChangeEvent event) {
                if (event.getProperty().getValue() instanceof Product) {
                    Product bean = (Product) event.getProperty().getValue();
                    productWindow.setBean(bean);
                    UI.getCurrent().addWindow(productWindow);
                }
            }
        });

    }

    private void initButton() {
        add = new Button("Add Product", new ClickListener() {

            private static final long serialVersionUID = -8229448971439741192L;

            @Override
            public void buttonClick(ClickEvent event) {
                productWindow.setBean(new Product());
                UI.getCurrent().addWindow(productWindow);
            }
        });
        add.setStyleName(ValoTheme.BUTTON_PRIMARY);
    }


    @Override
    protected Component getComponent() {
        return layout;
    }


    public void setList(List<Product> products) {
        table.setList(products);
    }

    public void setSucess(boolean isSucess) {
        if (isSucess) {
            Notification.show("Product saved Sucessfully");
        } else {
            Notification.show("Product Save failed");
        }
    }



}
