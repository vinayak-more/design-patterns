package com.sample.views;

import javax.annotation.PostConstruct;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.VaadinSessionScope;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.LoginForm;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * @author Vinayak More
 *
 * @date 29-Mar-2017
 */
@SpringView(name = TabSheetExample.NAME)
@VaadinSessionScope
public class TabSheetExample extends VerticalLayout implements View {

    private static final long serialVersionUID = 8501925965543839567L;
    public static final String NAME = "tabsheet";

    @PostConstruct
    public void init() {
        setSpacing(true);
        setMargin(true);
        TabSheet tabsheet = new TabSheet();
        LoginForm login1 = new LoginForm();
        LoginForm login2 = new LoginForm();
        LoginForm login3 = new LoginForm();
        LoginForm login4 = new LoginForm();
        LoginForm login5 = new LoginForm();
        tabsheet.addTab(login1, "Package Information", FontAwesome.CUBE);
        tabsheet.addTab(login2, "Itinerary", FontAwesome.SUN_O);
        tabsheet.addTab(login3, "Restrictions", FontAwesome.HAND_PAPER_O);
        tabsheet.addTab(login4, "Terms and Conditions", FontAwesome.GAVEL);
        tabsheet.addTab(login5, "Gallery", FontAwesome.PICTURE_O);
        addComponent(tabsheet);

        Accordion accordion = new Accordion();

        for (int i = 1; i < 5; i++) {
            accordion.addTab(new LoginForm(), "Login Form " + i, FontAwesome.USER);
        }
        addComponent(accordion);
       
    }

    @Override
    public void enter(ViewChangeEvent event) {
        System.out.println("TabSheetExample.enter()");
    }

}


