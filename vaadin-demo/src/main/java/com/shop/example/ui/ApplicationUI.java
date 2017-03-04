/**
 * @author Vinayak More
 *
 * @date 19-Nov-2016
 */
package com.shop.example.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;

import com.shop.example.ui.module.login.LoginBean;
import com.shop.example.ui.view.Header;
import com.shop.seller.module.login.DashBoardLoginForm;
import com.shop.seller.module.login.event.DashboardLoginSucess;
import com.shop.uikit.common.TemplateLayoutFactory;
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
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("valo")
@PreserveOnRefresh
@SpringUI(path = "/webapp")
public class ApplicationUI extends UI implements ViewDisplay {
    private static final long serialVersionUID = -8634385508890886118L;
    private Panel springViewDisplay;

    @Autowired
    private SpringViewProvider viewProvider;
    @Autowired
    DashBoardLoginForm loginForm;

    @Autowired
    private Header header;

    VerticalLayout layout;

    @Override
    public void showView(View view) {
        springViewDisplay.setContent((Component) view);
    }

    @Override
    protected void init(VaadinRequest request) {

        VaadinSession session = getSession();
        if (session.getAttribute(LoginBean.class.getName()) == null) {
            setContent(loginForm);
        } else {
            setContent(getMainLayout());
        }
    }

    @EventListener
    public void onLoginSucess(DashboardLoginSucess event) {
        setContent(getMainLayout());
    }

    private Component getMainLayout() {
        if (layout == null) {
            final CustomLayout navigationBar = TemplateLayoutFactory.getCustomLayput("accordian");
            final Panel viewContainer = new Panel();
            viewContainer.setSizeFull();
            Navigator navigator = new Navigator(this, viewContainer);
            navigator.addProvider(viewProvider);
            layout = new VerticalLayout();
            layout.setSizeFull();
            layout.addComponent(header);
            // layout.setExpandRatio(header, 1f);
            HorizontalLayout hLayout = new HorizontalLayout(navigationBar, viewContainer);
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
