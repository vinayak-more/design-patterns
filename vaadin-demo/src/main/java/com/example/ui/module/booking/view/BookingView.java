/**
 * @author Vinayak More
 *
 * @date 20-Nov-2016
 */
package com.example.ui.module.booking.view;

import javax.annotation.PostConstruct;

import org.springframework.boot.ApplicationArguments;
import org.springframework.context.ApplicationContext;

import com.example.common.TemplateLayoutFactory;
import com.example.common.uihelper.TextFieldHelper;
import com.example.ui.module.booking.controller.BookingViewController;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.VaadinSessionScope;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.TextField;

@VaadinSessionScope
@SpringView(name=BookingView.VIEW_NAME)
public class BookingView extends CustomComponent implements  View{
    private static final long serialVersionUID = 2740362779962133858L;
    public static final String VIEW_NAME="booking-view";
    private CustomLayout layout;
    private TextField productId;
    
    transient BookingViewController controller;
    
    public BookingView(BookingViewController controller) {
        super();
        this.controller=controller;
        layout=TemplateLayoutFactory.getCustomLayput("booking-view");
       
    }
    @PostConstruct
    public void init(){
      initComponents();
      addComponentToLayout();
      setCompositionRoot(layout);
    }
    private void addComponentToLayout() {
        layout.addComponent(productId, "product-id");
        controller.isInit();
        
    }
    private void initComponents() {
        productId=TextFieldHelper.helper("Product ID").required().getField();
    }
    
    //acts as on view enter
    @Override
    public void enter(ViewChangeEvent event) {
        
    }
}
