package com.retro.vaadin.module.dashboard;

import com.retro.vaadin.kit.uihelper.view.AbstractView;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;

/**
 * @author Vinayak More
 *
 * @date 17-May-2017
 */
@SpringView(name = DashboardView.NAME)
public class DashboardView extends AbstractView<DashboardController> {

    private static final long serialVersionUID = 1L;
    public static final String NAME = "";
    private Label label = new Label("Dashboard View");

    @Override
    protected Component getComponent() {
        return label;
    }

}
