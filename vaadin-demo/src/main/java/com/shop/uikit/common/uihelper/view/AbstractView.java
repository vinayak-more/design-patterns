/**
 * @author Vinayak More
 *
 * @date 24-Nov-2016
 */
package com.shop.uikit.common.uihelper.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;

public abstract class AbstractView<T extends AbstractController<?>> extends CustomComponent implements View {

    private static final long serialVersionUID = 7920534297181691858L;

    @Autowired
    private transient T controller;

    @Autowired
    protected transient ApplicationEventPublisher publisher;

    @Override
    public final void enter(ViewChangeEvent event) {
        controller.onViewEnter(this);
        setCompositionRoot(getComponent());
    }

    protected void publishEvent(ApplicationEvent event) {
        publisher.publishEvent(event);
    }


    protected abstract Component getComponent();

    protected T getController() {
        return controller;
    }

}
