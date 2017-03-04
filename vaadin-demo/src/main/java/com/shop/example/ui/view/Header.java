/**
 * @author Vinayak More
 *
 * @date 25-Nov-2016
 */
package com.shop.example.ui.view;

import javax.annotation.PostConstruct;

import com.shop.uikit.common.TemplateLayoutFactory;
import com.shop.uikit.common.uihelper.components.TextFieldHelper;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinSessionScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

@VaadinSessionScope
@SpringComponent
public class Header extends CustomComponent {
    private static final long serialVersionUID = -9161769120489350677L;

    @PostConstruct
    public void init(){
        TextField textField=new TextField();
        textField.setInputPrompt("Booking ID");
        HorizontalLayout hLayout=new HorizontalLayout(textField);
        hLayout.setWidth("100%");
        hLayout.setHeight(null);
        hLayout.setComponentAlignment(textField, Alignment.MIDDLE_CENTER);
        hLayout.addStyleName(ValoTheme.PANEL_WELL);
        setCompositionRoot(hLayout);
    }
}
