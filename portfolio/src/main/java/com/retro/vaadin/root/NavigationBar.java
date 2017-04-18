package com.retro.vaadin.root;

import javax.annotation.PostConstruct;

import com.vaadin.navigator.Navigator;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinSessionScope;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.MenuBar;

/**
 * @author Vinayak More
 *
 * @date 17-Apr-2017
 */
@SpringComponent
@VaadinSessionScope
public class NavigationBar extends CustomComponent {
    private static final long serialVersionUID = 1L;
    private MenuBar menuBar;
    private AbstractOrderedLayout layout;
    private Navigator navigator;

    @PostConstruct
    public void init() {
        layout = new HorizontalLayout();
        initMenuBar();
        layout.addComponent(menuBar);
        setCompositionRoot(layout);
    }

    private void initMenuBar() {
        menuBar = new MenuBar();
        menuBar.addItem("Investments", e -> navigator.navigateTo("investment"));
        menuBar.addItem("Transactions", e -> navigator.navigateTo("transactions"));
    }

    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;

    }

}
