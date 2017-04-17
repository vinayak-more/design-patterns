/**
 * @author Vinayak More
 *
 * @date 26-Nov-2016
 */
package com.retro.vaadin.kit.uihelper.components;

import static org.springframework.util.StringUtils.capitalize;
import com.vaadin.ui.Button;

public class ButtonHelper {

    public static Helper helper(String caption) {
        return new Helper(caption);
    }

    public static class Helper {
        Button button;

        public Helper(String caption) {
            button = new Button(capitalize(caption));
        }

        public Button getField() {
            return button;
        }

        public Helper addStyleName(String styleName) {
            button.addStyleName(styleName);
            return this;
        }

        public Helper addClickLister(Button.ClickListener listener) {
            button.addClickListener(listener);
            return this;
        }

        public Helper addStylePrimary() {
            button.addStyleName("btn-primary");
            return this;
        }

        public Helper addStyleSecondary() {
            button.addStyleName("btn-warning");
            return this;
        }

        public Helper addStyleDelete() {
            button.addStyleName("btn-danger");
            return this;
        }
    }

}
