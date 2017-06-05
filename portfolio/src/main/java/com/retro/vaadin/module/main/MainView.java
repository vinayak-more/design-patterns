package com.retro.vaadin.module.main;

import javax.annotation.PostConstruct;

import com.retro.vaadin.kit.uihelper.view.AbstractView;
import com.retro.vaadin.module.transaction.component.StockSuggestBox;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Vinayak More
 *
 * @date 01-May-2017
 */
@SpringView(name = MainView.NAME)
@ViewScope
public class MainView extends AbstractView<MainController> {

    private static final long serialVersionUID = 1L;
    public static final String NAME = "test";
    private VerticalLayout layout = new VerticalLayout();
    private StockSuggestBox box = new StockSuggestBox("Suggest Test");

    @PostConstruct
    public void init() {
        layout.addComponent(box);
    }

    @Override
    protected Component getComponent() {
        return layout;
    }

}
