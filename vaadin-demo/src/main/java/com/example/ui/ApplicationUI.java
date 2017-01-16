/**
 * @author Vinayak More
 *
 * @date 19-Nov-2016
 */
package com.example.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.common.TemplateLayoutFactory;
import com.example.ui.view.Header;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("valo")
@SpringUI(path="/webapp")
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
        final CustomLayout navigationBar = TemplateLayoutFactory.getCustomLayput("accordian");
        final Panel viewContainer = new Panel();
        viewContainer.setSizeFull();
        Navigator navigator = new Navigator(this, viewContainer);
        navigator.addProvider(viewProvider);
        VerticalLayout layout =new VerticalLayout();
        layout.setSizeFull();
        layout.addComponent(header);
//        layout.setExpandRatio(header, 1f);
        HorizontalLayout hLayout=new HorizontalLayout(navigationBar,viewContainer);
        hLayout.setSizeFull();
        layout.addComponent(hLayout);
        hLayout.setExpandRatio(navigationBar, 0.15f);
        hLayout.setExpandRatio(viewContainer, 0.84f);
        layout.setExpandRatio(hLayout, 0.9f);
        Responsive.makeResponsive(layout);
        setContent(layout);
    }

}
