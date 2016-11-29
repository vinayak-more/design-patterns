/**
 * @author Vinayak More
 *
 * @date 20-Nov-2016
 */
package com.example.ui.module.booking.view;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.common.TemplateLayoutFactory;
import com.example.common.uihelper.view.AbstactView;
import com.example.ui.module.booking.controller.BookingViewController;
import com.example.ui.module.booking.view.nestedview.IdolView;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.VaadinSessionScope;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@VaadinSessionScope
@SpringView(name = BookingView.VIEW_NAME)
public class BookingView extends AbstactView<BookingViewController> {

    private static final long serialVersionUID = 2740362779962133858L;
    public static final String VIEW_NAME = "booking-view";
    private CustomLayout layout;
    private TabSheet tabsheet;
    
    @Autowired
    IdolView idolView;

    @PostConstruct
    public void init() {
        layout = TemplateLayoutFactory.getCustomLayput("booking-view");
        initComponents();
        addComponentToLayout();
        setCompositionRoot(new VerticalLayout(idolView));
        //FIXME remove this stub later
        //stub();
    }


    private void initComponents() {
//        tabsheet = new TabSheet();
//        tabsheet.setHeight(100.0f, Unit.PERCENTAGE);
//        tabsheet.addStyleName(ValoTheme.TABSHEET_FRAMED);
//        tabsheet.addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);
//        tabsheet.setSizeFull();
//        tabsheet.addTab(idolView,"Idol View");
//        layout.addComponent(idolView);
        
    }

    private void addComponentToLayout() {
//        layout.addComponent(tabsheet, "tabsheet");
    }

    private void stub() {
        for (int i = 1; i < 3; i++) {
            final VerticalLayout tempLayout = new VerticalLayout(new Label("Tab " + i, ContentMode.HTML));
            tempLayout.setMargin(true);
            tabsheet.addTab(tempLayout, "Tab " + i);
        }
    }
}
