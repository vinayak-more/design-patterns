/**
 * @author Vinayak More
 * @date 17-Apr-2017
 */
package com.retro.vaadin.module.investment;

import java.util.List;

import javax.annotation.PostConstruct;

import com.retro.vaadin.kit.TemplateLayoutFactory;
import com.retro.vaadin.kit.uihelper.components.table.VaadinTable;
import com.retro.vaadin.kit.uihelper.view.AbstractView;
import com.retro.vaadin.module.investment.event.RefreshInvestmentData;
import com.retro.web.bean.Investment;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomLayout;
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
    private CustomLayout layout;
    private VaadinTable<Investment> table;
    private Button refreshData;

    @PostConstruct
    public void init() {
        layout = TemplateLayoutFactory.getCustomLayout("investment-view");
        initComponent();
        addComponent();
    }

    private void initComponent() {
        table =
                VaadinTable.createTable(Investment.class, "symbol", "quantity", "investment", "currentValue",
                        "changeValue", "changePercentage", "todaysGain", "lasUpdated");
        refreshData = new Button("", e -> publishEvent(new RefreshInvestmentData(this)));
        refreshData.addStyleName(ValoTheme.BUTTON_PRIMARY);
        refreshData.setIcon(FontAwesome.REFRESH);
    }

    private void addComponent() {
        layout.addComponent(refreshData, "refresh");
        layout.addComponent(table, "table");
    }

    @Override
    protected Component getComponent() {
        return layout;
    }

    public void setList(List<Investment> beanList) {
        table.setList(beanList);
    }

}
