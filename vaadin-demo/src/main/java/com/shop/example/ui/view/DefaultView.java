/**
 * @author Vinayak More
 *
 * @date 19-Nov-2016
 */
package com.shop.example.ui.view;

import javax.annotation.PostConstruct;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.VaadinSessionScope;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
@VaadinSessionScope
@SpringView(name=DefaultView.VIEW_NAME)
public class DefaultView extends VerticalLayout implements View {
    private static final long serialVersionUID = -1636387685666427664L;
    public static final String VIEW_NAME = "";
    
    @PostConstruct
    public void init(){
        addComponent(new Label("This is the default view"));
    }
    @Override
    public void enter(ViewChangeEvent event) {

    }

}
