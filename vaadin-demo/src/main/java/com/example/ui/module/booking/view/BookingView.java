/**
 * @author Vinayak More
 *
 * @date 20-Nov-2016
 */
package com.example.ui.module.booking.view;

import javax.annotation.PostConstruct;

import com.example.common.TemplateLayoutFactory;
import com.example.common.uihelper.components.TextFieldHelper;
import com.example.common.uihelper.view.AbstactView;
import com.example.ui.module.booking.controller.BookingViewController;
import com.example.ui.module.booking.event.TestEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.VaadinSessionScope;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.TextField;

@VaadinSessionScope
@SpringView(name = BookingView.VIEW_NAME)
public class BookingView extends AbstactView<BookingViewController> {

    private static final long serialVersionUID = 2740362779962133858L;
    public static final String VIEW_NAME = "booking-view";
    private CustomLayout layout;
    private TextField productId;

    @PostConstruct
    public void init() {
        layout = TemplateLayoutFactory.getCustomLayput("booking-view");
        initComponents();
        addComponentToLayout();
        setCompositionRoot(layout);
    }

    private void addComponentToLayout() {
        layout.addComponent(productId, "product-id");
    }

    private void initComponents() {
        productId = TextFieldHelper.helper("Product ID").required().getField();
        publishEvent(new TestEvent("Hello World!! I m an Event"));

    }
}
