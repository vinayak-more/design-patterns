package com.retro.vaadin.root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;

import com.retro.vaadin.module.login.bean.LoginSucessEvent;
import com.retro.vaadin.module.login.component.LoginForm;
import com.retro.web.bean.User;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Vinayak More
 *
 * @date 17-Apr-2017
 */
@Theme("valo")
@PreserveOnRefresh
@SpringUI(path = "/")
public class ApplicationUI extends UI implements ViewDisplay {
    private static final long serialVersionUID = 1L;
    private VerticalLayout layout;

    @Autowired
    private SpringViewProvider viewProvider;

    @Autowired
    private NavigationBar navigationBar;

    @Autowired
    private Header header;

    @Autowired
    private LoginForm loginForm;


    @Override
    public void showView(View view) {}

    @Override
    protected void init(VaadinRequest request) {
        VaadinSession session = getSession();
        if (session != null && session.getAttribute(User.class.getName()) == null) {
            setContent(loginForm);
        } else {
            setContent(getMainLayout());
        }

    }

    @EventListener
    public void loginSucess(LoginSucessEvent event) {
        setContent(getMainLayout());
    }

    private Component getMainLayout() {
        if (layout == null) {
            final Panel viewContainer = new Panel();
            viewContainer.setSizeFull();
            Navigator navigator = new Navigator(this, viewContainer);
            navigator.addProvider(viewProvider);
            layout = new VerticalLayout();
            layout.setSizeFull();
            layout.addComponent(header);
            navigationBar.setNavigator(navigator);
            // layout.setExpandRatio(header, 1f);
            AbstractOrderedLayout hLayout = new VerticalLayout(navigationBar, viewContainer);
            hLayout.setSizeFull();
            layout.addComponent(hLayout);
            hLayout.setExpandRatio(navigationBar, 0.15f);
            hLayout.setExpandRatio(viewContainer, 0.84f);
            layout.setExpandRatio(hLayout, 0.9f);
            Responsive.makeResponsive(layout);
        }
        return layout;
    }
}
