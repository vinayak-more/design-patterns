/**
 * @author Vinayak More
 *
 * @date 20-Nov-2016
 */
package com.shop.example.ui;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringComponent
public class NavigationBar extends CssLayout {

    private static final long serialVersionUID = -2833162246369131680L;
    public NavigationBar(){
        addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
    }
    

    public void addNavigation(String caption,String viewName) {
        addComponent(createNavigationButton(caption,viewName));
    }
    
    private Button createNavigationButton(String caption, final String viewName) {
        Button button = new Button(caption);
        button.addStyleName(ValoTheme.BUTTON_SMALL);
        // If you didn't choose Java 8 when creating the project, convert this
        // to an anonymous listener class
        button.addClickListener(event -> getUI().getNavigator().navigateTo(viewName));
        return button;
    }
    
}
