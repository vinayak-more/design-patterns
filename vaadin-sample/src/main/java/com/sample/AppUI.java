package com.sample;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Vinayak More
 *
 * @date 28-Mar-2017
 */

@Theme("valo")
@PreserveOnRefresh
@SpringUI(path = "/sample")
public class AppUI extends UI implements ViewDisplay{

    private VerticalLayout layout;
    @Autowired
    private SpringViewProvider viewProvider;
    
    @Override
    protected void init(VaadinRequest request) {
        layout=new VerticalLayout();
        layout.setSpacing(true);
        layout.setMargin(true);
        final Panel viewContainer = new Panel();
        viewContainer.setSizeFull();
        Navigator navigator = new Navigator(this, viewContainer);
        navigator.addProvider(viewProvider);
        layout.addComponent(viewContainer);
        setContent(layout);

    }

    
    @Override
    public void showView(View view) {
        
    }

}

