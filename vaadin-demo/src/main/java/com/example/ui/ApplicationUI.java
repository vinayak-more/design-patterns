/**
 * @author Vinayak More
 *
 * @date 19-Nov-2016
 */
package com.example.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.common.TemplateLayoutFactory;
import com.example.ui.view.Header;
import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;

@Theme("valo")
@JavaScript( value = { "jquery.min.js", "bootstrap.min.js" })
@SpringUI
public class ApplicationUI extends UI implements ViewDisplay{
    private static final long serialVersionUID = -8634385508890886118L;
    private Panel springViewDisplay;

    @Autowired
    private SpringViewProvider viewProvider;
    
    @Autowired
    private Header header;
    @Override
    public void showView(View view) {
        springViewDisplay.setContent((Component) view);
    }

    @Override
    protected void init(VaadinRequest request) {
        CustomLayout home=TemplateLayoutFactory.getCustomLayput("home");
        home.setHeight("100%");
        final CustomLayout navigationBar = TemplateLayoutFactory.getCustomLayput("accordian");
        navigationBar.setWidth("15%");
        final Panel viewContainer = new Panel();
        viewContainer.setWidth("84%");
        viewContainer.setHeight("100%");
        Navigator navigator = new Navigator(this, viewContainer);
        navigator.addProvider(viewProvider);
        home.addComponent(header, "header");
        home.addComponent(navigationBar, "accordian");
        home.addComponent(viewContainer,"panel");
        setContent(home);
        
    }

}
