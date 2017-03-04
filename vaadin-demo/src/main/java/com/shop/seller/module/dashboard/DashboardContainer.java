/**
 * @author Vinayak More
 *
 * @date 02-Mar-2017
 */
package com.shop.seller.module.dashboard;

import javax.annotation.PostConstruct;

import org.springframework.context.event.EventListener;

import com.shop.seller.module.dashboardUI.event.BrowserResizeEvent;
import com.vaadin.server.Page.BrowserWindowResizeEvent;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;

@SpringComponent
@UIScope
public class DashboardContainer extends CustomComponent {

    private static final long serialVersionUID = -5340134211114041658L;
    
    @PostConstruct
    public void init(){
        setCompositionRoot(new Label("Welcome to Dashboard"));
    }
    
    @EventListener
    public void onBrowserResizeEvent(BrowserResizeEvent event){
        System.out.println("DashboardContainer.onBrowserResizeEvent(event)");
    }

}
