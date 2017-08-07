package com.retro.vaadin.module.investment;

import java.util.List;

import javax.annotation.PostConstruct;

import com.retro.vaadin.kit.uihelper.view.AbstractView;
import com.retro.vaadin.module.investment.event.RefreshInvestmentData;
import com.retro.web.bean.Investment;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;


/**
 * @author Vinayak More
 *
 * @date 17-Apr-2017
 */
@SpringView(name = InvestmentView.NAME)
public class InvestmentView extends AbstractView<InvestmentController> {
    private static final long serialVersionUID = 1L;
    public static final String NAME = "investment";
    private VerticalLayout layout;
    private Button refreshData;
    private Grid<Investment> grid;

    @PostConstruct
    public void init() {
        layout = new VerticalLayout();//.getCustomLayout("investment-view");
        initComponent();
        addComponent();
    }

    private void initComponent() {
        grid = new Grid<Investment>(Investment.class);
        grid.setColumns("symbol","currentPrice", "quantity", "investment", "currentValue", "lastUpdated");
        grid.setStyleGenerator(i->i.getChangeValue()>0?"green":"red");
        grid.setSizeFull();
        refreshData = new Button("", e -> publishEvent(new RefreshInvestmentData(this)));
        refreshData.addStyleName(ValoTheme.BUTTON_PRIMARY);
        refreshData.setIcon(VaadinIcons.REFRESH);
    }

    private void addComponent() {
//        layout.addComponent(refreshData, "refresh");
//        layout.addComponent(grid, "table");
        layout.addComponents(refreshData,grid);
        layout.setSizeFull();
    }

    @Override
    protected Component getComponent() {
        return layout;
    }

    public void setList(List<Investment> beanList) {
        grid.setItems(beanList);
    }
}
