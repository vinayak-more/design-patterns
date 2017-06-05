package com.retro.vaadin.root;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import com.retro.vaadin.module.login.event.LogoutEvent;
import com.retro.web.bean.User;
import com.vaadin.navigator.Navigator;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.spring.annotation.ViewScope;
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
@UIScope
public class NavigationBar extends CustomComponent {
    private static final long serialVersionUID = 1L;
    private MenuBar menuBar;
    private AbstractOrderedLayout layout;
    private Navigator navigator;

    @Autowired
    private ApplicationEventPublisher publisher;

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
        menuBar.addItem("Log out", e -> {
            getSession().setAttribute(User.class.getName(), null);
            publisher.publishEvent(new LogoutEvent());
        });
    }

    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;

    }

}
