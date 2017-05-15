package com.retro.vaadin.kit.uihelper.window;

import com.vaadin.ui.Window;

/**
 * @author Vinayak More
 *
 * @date 19-Apr-2017
 */
public class PopupWindow extends Window {
    private static final long serialVersionUID = 1L;

    public PopupWindow(String caption) {
        super(caption);
        setModal(true);
        center();
        setResizable(false);
    }

}
