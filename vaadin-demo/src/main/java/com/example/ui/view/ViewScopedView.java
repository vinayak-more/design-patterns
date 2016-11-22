/**
 * @author Vinayak More
 *
 * @date 19-Nov-2016
 */
package com.example.ui.view;

import javax.annotation.PostConstruct;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = ViewScopedView.VIEW_NAME)
public class ViewScopedView extends VerticalLayout implements View {
    private static final long serialVersionUID = -438819072388136477L;
    public static final String VIEW_NAME = "view";

    @PostConstruct
    public void init() {
        setMargin(true);
        setSpacing(true);
        addComponent(new Label("This is a view scoped view"));
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // TODO Auto-generated method stub
       System.out.println("ViewScopedView.enter()");
    }
}
