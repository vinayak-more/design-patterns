/**
 * @author Vinayak More
 *
 * @date 27-Nov-2016
 */
package com.example.common.uihelper.layout;

import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

public class VerticalLayoutHelper {
    public static Helper helper(Component... components) {
        return new Helper(components);
    }

    public static class Helper {
        VerticalLayout layout;

        public Helper(Component... components) {
            layout = new VerticalLayout(components);
        }

        public VerticalLayout getLayout() {
            return layout;
        }

        public Helper setSpacing(boolean spacing) {
            layout.setSpacing(spacing);
            return this;
        }

        public Helper addStyleName(String style) {
            layout.addStyleName(style);
            return this;
        }
    }
}
