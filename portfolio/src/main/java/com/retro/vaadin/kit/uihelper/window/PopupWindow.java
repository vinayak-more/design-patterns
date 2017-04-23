package com.retro.vaadin.kit.uihelper.window;

import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * @author Vinayak More
 *
 * @date 19-Apr-2017
 */
public class PopupWindow extends Window {
    private static final long serialVersionUID = 1L;
    protected final VerticalLayout layout = new VerticalLayout();

    public PopupWindow(String caption) {
        super(caption);
        setModal(true);
        center();
        setResizable(false);
        layout.setSpacing(true);
        layout.setMargin(true);
        super.setContent(layout);
    }

    @Override
    public void setContent(Component content) {
        layout.addComponent(content);
    }
}
