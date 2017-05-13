package com.retro.vaadin.root;

import javax.annotation.PostConstruct;

import com.retro.vaadin.kit.TemplateLayoutFactory;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.CustomLayout;

/**
 * @author Vinayak More
 *
 * @date 12-May-2017
 */
@SpringComponent
public class ApplicationLayout extends CustomComponent {
    
    private CustomLayout layout;
    
    @PostConstruct
    public void init(){
       layout=TemplateLayoutFactory.getCustomLayout("app-layout");
       setCompositionRoot(layout);
    }

}
