/**
 * @author Vinayak More
 *
 * @date 24-Nov-2016
 */
package com.example.common.uihelper.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;

public abstract class AbstactView<T extends AbstractController<?>> extends CustomComponent implements View{

    private static final long serialVersionUID = 7920534297181691858L;

    @Autowired
    private transient T controller;
    
    @Autowired
    protected transient ApplicationEventPublisher publisher;
    
    @Override
    public final void enter(ViewChangeEvent event) {
        controller.onViewEnter();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((controller == null) ? 0 : controller.hashCode());
        return result;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        AbstactView other = (AbstactView) obj;
        if (controller == null) {
            if (other.controller != null)
                return false;
        } else if (!controller.equals(other.controller))
            return false;
        return true;
    }
    
    protected void publishEvent(ApplicationEvent event){
        publisher.publishEvent(event);
    }
    
    protected T getController() {
        return controller;
    }

}
