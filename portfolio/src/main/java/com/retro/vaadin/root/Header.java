package com.retro.vaadin.root;

import javax.annotation.PostConstruct;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinSessionScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;

/**
 * @author Vinayak More
 *
 * @date 17-Apr-2017
 */
@SpringComponent
@VaadinSessionScope
public class Header extends CustomComponent {

    private static final long serialVersionUID = 1L;
    private Label title;

    @PostConstruct
    public void init() {

        title = new Label("Portfolio");
        title.addStyleName(ValoTheme.LABEL_BOLD);
        title.addStyleName(ValoTheme.LABEL_H3);
        title.addStyleName(ValoTheme.LABEL_COLORED);
        HorizontalLayout hLayout = new HorizontalLayout(title);
        hLayout.setWidth("100%");
        hLayout.setComponentAlignment(title, Alignment.MIDDLE_RIGHT);
        hLayout.addStyleName(ValoTheme.PANEL_WELL);
        setCompositionRoot(hLayout);

    }

}
