package com.retro.vaadin.root;

import javax.annotation.PostConstruct;

import com.retro.vaadin.kit.TemplateLayoutFactory;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.CustomLayout;

/**
 * @author Vinayak More
 *
 * @date 17-Apr-2017
 */
@SpringComponent
public class Header extends CustomComponent {

    private static final long serialVersionUID = 1L;
    private CustomLayout layout;

    @PostConstruct
    public void init() {
        layout=TemplateLayoutFactory.getCustomLayout("header");
        setSizeUndefined();
        addStyleName("app-header");
        setCompositionRoot(layout);
    }

}
