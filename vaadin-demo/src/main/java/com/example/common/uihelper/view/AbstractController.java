/**
 * @author Vinayak More
 *
 * @date 24-Nov-2016
 */
package com.example.common.uihelper.view;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.vaadin.spring.navigator.SpringViewProvider;



public abstract class AbstractController<V extends AbstactView<?>> {

//    @Autowired
//    private SpringViewProvider viewProvider;
    
    private String viewName;

//    @PostConstruct
//    protected void init() {
//        viewName = getViewName();
//    }
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractController.class);
    public abstract void onViewEnter();
//    private String getViewName() {
//        String result = null;
//        Class<?> clazz = getClass();
//        if (clazz.isAnnotationPresent(Controller.class)) {
//            Controller vp = clazz.getAnnotation(Controller.class);
//            result = vp.value();
//        } else {
//            LOGGER.error("Presenter [{}] does not have a @Controller annotation!", clazz.getSimpleName());
//        }
//        return result;
//    }
//    @SuppressWarnings("unchecked")
//    public V getView() {
//        V result = null;
//        if (viewName != null) {
//            result = (V) viewProvider.getView(viewName);
//        }
//        return result;
//    }
}
