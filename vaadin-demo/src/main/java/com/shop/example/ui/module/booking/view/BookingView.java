/**
 * @author Vinayak More
 *
 * @date 20-Nov-2016
 */
package com.shop.example.ui.module.booking.view;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.shop.example.ui.module.booking.controller.BookingViewController;
import com.shop.example.ui.module.booking.view.nestedview.IdolView;
import com.shop.uikit.common.TemplateLayoutFactory;
import com.shop.uikit.common.uihelper.view.AbstractView;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.VerticalLayout;

@UIScope
@SpringView(name = BookingView.VIEW_NAME)
public class BookingView extends AbstractView<BookingViewController> {

    private static final long serialVersionUID = 2740362779962133858L;
    public static final String VIEW_NAME = "booking-view";
    private CustomLayout layout;
    
    @Autowired
    IdolView idolView;

    @PostConstruct
    public void init() {
        layout = TemplateLayoutFactory.getCustomLayput("booking-view");
//        setCompositionRoot(new VerticalLayout(idolView));
    }





    @Override
    protected Component getComponent() {
        return new VerticalLayout(idolView);
    }

    
}
