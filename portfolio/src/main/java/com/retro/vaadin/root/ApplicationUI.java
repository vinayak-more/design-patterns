package com.retro.vaadin.root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;

import com.retro.vaadin.module.login.component.LoginForm;
import com.retro.vaadin.module.login.event.LoginSucessEvent;
import com.retro.vaadin.module.login.event.LogoutEvent;
import com.retro.web.bean.User;
import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;

/**
 * @author Vinayak More
 *
 * @date 17-Apr-2017
 */
@Theme("retro")
@PreserveOnRefresh
@JavaScript({"jquery.js", "bootstrap.min.js"})
@SpringUI(path = "/")
public class ApplicationUI extends UI implements ViewDisplay {
    private static final long serialVersionUID = 1L;

    @Autowired
    private SpringViewProvider viewProvider;

    @Autowired
    private NavigationBar navigationBar;

    @Autowired
    private Header header;

    @Autowired
    private ApplicationLayout appLayout;

    @Autowired
    private LoginForm loginForm;


    @Override
    public void showView(View view) {
        System.out.println("ApplicationUI.showView()");
    }

    @Override
    protected void init(VaadinRequest request) {
        VaadinSession session = getSession();
        if (session != null && session.getAttribute(User.class.getName()) == null) {
            setContent(loginForm);
        } else {
            init();
            setContent(appLayout);
        }

    }

    private void init() {
        final Panel viewContainer = appLayout.getPanel();
        viewContainer.setSizeFull();
        Navigator navigator = new Navigator(this, viewContainer);
        navigator.addProvider(viewProvider);
    }

    @EventListener
    public void loginSucess(LoginSucessEvent event) {
        init();
        setContent(appLayout);
    }

    @EventListener
    public void logout(LogoutEvent event) {
        setContent(loginForm);
    }

}
