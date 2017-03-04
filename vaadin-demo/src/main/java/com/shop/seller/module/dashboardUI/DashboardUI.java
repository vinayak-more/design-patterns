/**
 * @author Vinayak More
 *
 * @date 02-Mar-2017
 */
package com.shop.seller.module.dashboardUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;

import com.shop.example.ui.module.login.LoginBean;
import com.shop.seller.module.dashboard.DashboardContainer;
import com.shop.seller.module.dashboardUI.event.BrowserResizeEvent;
import com.shop.seller.module.login.DashBoardLoginForm;
import com.shop.seller.module.login.event.DashboardLoginSucess;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.Page;
import com.vaadin.server.Page.BrowserWindowResizeEvent;
import com.vaadin.server.Page.BrowserWindowResizeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;

@Theme("valo")
@PreserveOnRefresh
@SpringUI
public class DashboardUI extends UI implements ViewDisplay {
    @Autowired
    private SpringViewProvider viewProvider;

    private static final long serialVersionUID = 4580676022209710428L;

    private Panel springViewDisplay;

    @Autowired
    ApplicationEventPublisher publisher;
    @Autowired
    DashBoardLoginForm loginForm;

    @Autowired
    DashboardContainer dashboardContainer;

    @Override
    protected void init(VaadinRequest request) {
        System.out.println("DashboardUI.init()");
        final Panel viewContainer = new Panel();
        viewContainer.setSizeFull();
        Navigator navigator = new Navigator(this, viewContainer);
        navigator.addProvider(viewProvider);
        initResizeListner();
        VaadinSession session = getSession();
        if (session.getAttribute(LoginBean.class.getName()) == null) {
            setContent(loginForm);
        } else {
            setContent(dashboardContainer);
        }
    }

    private void initResizeListner() {
        Page.getCurrent().addBrowserWindowResizeListener(new BrowserWindowResizeListener() {

            private static final long serialVersionUID = -4911440189579851089L;

            @Override
            public void browserWindowResized(BrowserWindowResizeEvent event) {
                publisher.publishEvent(new BrowserResizeEvent());
            }
        });

    }

    @Override
    public void showView(View view) {
        springViewDisplay.setContent((Component) view);

    }

    @EventListener
    public void onLoginSucess(DashboardLoginSucess event) {
        setContent(dashboardContainer);
    }

}
