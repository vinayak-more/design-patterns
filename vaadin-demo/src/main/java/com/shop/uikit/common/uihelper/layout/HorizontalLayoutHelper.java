/**
 * @author Vinayak More
 *
 * @date 27-Nov-2016
 */
package com.shop.uikit.common.uihelper.layout;

import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;

public class HorizontalLayoutHelper {

    public static Helper helper(Component... components) {
        return new Helper(components);
    }

    public static class Helper {
        HorizontalLayout layout;

        public Helper(Component... components) {
            layout = new HorizontalLayout(components);
        }

        public HorizontalLayout getLayout() {
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
        public Helper setSizeFull(){
            layout.setSizeFull();
            return this;
        }
    }
}
