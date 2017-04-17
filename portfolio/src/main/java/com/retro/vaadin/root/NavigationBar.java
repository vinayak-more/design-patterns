package com.retro.vaadin.root;

import javax.annotation.PostConstruct;

import com.vaadin.navigator.Navigator;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinSessionScope;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;

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
        menuBar.addItem("Investments", new Command() {

            private static final long serialVersionUID = 1L;

            @Override
            public void menuSelected(MenuItem selectedItem) {
                navigator.navigateTo("investment");
            }
        });
        menuBar.addItem("Transactions", new Command() {
            
            @Override
            public void menuSelected(MenuItem selectedItem) {
                navigator.navigateTo("transactions");
            }
        });

    }

    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;

    }

}
