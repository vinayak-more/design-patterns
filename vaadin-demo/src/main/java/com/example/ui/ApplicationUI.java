/**
 * @author Vinayak More
 *
 * @date 19-Nov-2016
 */
package com.example.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.ui.module.booking.view.BookingView;
import com.example.ui.view.DefaultView;
import com.example.ui.view.ViewScopedView;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@Theme("valo")
@SpringUI
public class ApplicationUI extends UI implements ViewDisplay{
    private static final long serialVersionUID = -8634385508890886118L;
    private Panel springViewDisplay;

    @Autowired
    private SpringViewProvider viewProvider;
    
    private Button createNavigationButton(String caption, final String viewName) {
        Button button = new Button(caption);
        button.addStyleName(ValoTheme.BUTTON_SMALL);
        button.setDescription("<div><h1>Hiii Vinayak</h1></div>");
        // If you didn't choose Java 8 when creating the project, convert this
        // to an anonymous listener class
        button.addClickListener(event -> getUI().getNavigator().navigateTo(viewName));
        return button;
    }

    @Override
    public void showView(View view) {
        springViewDisplay.setContent((Component) view);
    }

    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout root = new VerticalLayout();
        root.setSizeFull();
        root.setMargin(true);
        root.setSpacing(true);
        root.setDescription("Vertical"); 
        setContent(root);

        final CssLayout navigationBar = new CssLayout();
        navigationBar.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        navigationBar.addComponent(createNavigationButton("View Default View", DefaultView.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("View Scoped View", ViewScopedView.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("Booking View", BookingView.VIEW_NAME));
        root.addComponent(navigationBar);

        final Panel viewContainer = new Panel();
        viewContainer.setSizeFull();
        root.addComponent(viewContainer);
        root.setExpandRatio(viewContainer, 1.0f);

        Navigator navigator = new Navigator(this, viewContainer);
        navigator.addProvider(viewProvider);

    }

}
