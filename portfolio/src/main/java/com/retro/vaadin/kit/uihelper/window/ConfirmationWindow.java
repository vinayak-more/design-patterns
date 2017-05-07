package com.retro.vaadin.kit.uihelper.window;


import com.vaadin.shared.Registration;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Vinayak More
 *
 * @date 07-May-2017
 */
public class ConfirmationWindow extends PopupWindow {

    private static final long serialVersionUID = 1L;
    private Button yes = new Button("Yes");
    private Button no = new Button("No");
    private ConfirmationWindowListener listener;
    private VerticalLayout layout = new VerticalLayout();;
    private Label info = new Label();

    public ConfirmationWindow(String caption, String message) {
        super(caption);
        info.setCaption(message);
        no.addClickListener(e -> close());
        yes.addClickListener(e -> {
            if (listener != null) {
                listener.onConfimation();
                close();
            }
        });
        layout.addComponents(info, new HorizontalLayout(yes, no));
        setContent(layout);
    }

    public void show() {
        UI.getCurrent().addWindow(this);
    }

    public Registration setConfirmationWindowListener(ConfirmationWindowListener listener1) {
        this.listener = listener1;
        return new Registration() {

            private static final long serialVersionUID = 1L;

            @Override
            public void remove() {
                listener = null;

            }
        };
    }

}
