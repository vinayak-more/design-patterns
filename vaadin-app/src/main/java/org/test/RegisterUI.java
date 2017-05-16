package org.test;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Vinayak More
 *
 * @date 15-May-2017
 */
public class RegisterUI extends UI {

    private static final long serialVersionUID = 1L;
    private VerticalLayout layout = new VerticalLayout();

    @Override
    protected void init(VaadinRequest request) {
        layout.addComponent(new Label("New Popup window"));
        setContent(layout);
    }

}
