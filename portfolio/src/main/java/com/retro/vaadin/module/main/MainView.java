package com.retro.vaadin.module.main;

import javax.annotation.PostConstruct;

import com.retro.vaadin.kit.uihelper.view.AbstractView;
import com.retro.vaadin.module.transaction.component.SuggestBox;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Vinayak More
 *
 * @date 01-May-2017
 */
@SpringView(name = MainView.NAME)
public class MainView extends AbstractView<MainController> {

    private static final long serialVersionUID = 1L;
    public static final String NAME = "test";
    private VerticalLayout layout = new VerticalLayout();
    private SuggestBox box = new SuggestBox("Suggest Test");

    @PostConstruct
    public void init() {
        layout.addComponent(box);
    }

    @Override
    protected Component getComponent() {
        return layout;
    }

}
