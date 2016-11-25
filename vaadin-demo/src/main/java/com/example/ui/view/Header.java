/**
 * @author Vinayak More
 *
 * @date 25-Nov-2016
 */
package com.example.ui.view;

import javax.annotation.PostConstruct;

import com.example.common.TemplateLayoutFactory;
import com.example.common.uihelper.components.TextFieldHelper;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinSessionScope;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.TextField;

@VaadinSessionScope
@SpringComponent
public class Header extends CustomComponent {
    private static final long serialVersionUID = -9161769120489350677L;

    TextField bookingId;
    CustomLayout layout;
    @PostConstruct
    public void init(){
        layout=TemplateLayoutFactory.getCustomLayput("header");
        bookingId=TextFieldHelper.helper("").getField();
        bookingId.setInputPrompt("Booking ID");
        layout.addComponent(bookingId, "booking-id");
        setCompositionRoot(layout);
    }
}
