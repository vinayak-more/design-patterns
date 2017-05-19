package com.retro.vaadin.root;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.retro.vaadin.kit.TemplateLayoutFactory;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Panel;

/**
 * @author Vinayak More
 *
 * @date 12-May-2017
 */
@SpringComponent
public class ApplicationLayout extends CustomComponent {

    private static final long serialVersionUID = 1L;
    private CustomLayout layout;
    private Panel panel = new Panel();
    
    @Autowired
    private Header header;

    @PostConstruct
    public void init() {
        layout = TemplateLayoutFactory.getCustomLayout("app-layout");
        panel.setSizeFull();
        layout.addComponent(header,"header");
        layout.addComponent(panel, "content");
        setCompositionRoot(layout);
    }

    public Panel getPanel() {
        return panel;
    }
}
