package com.retro.vaadin.module.transaction;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.retro.vaadin.kit.uihelper.view.AbstractView;
import com.retro.vaadin.module.transaction.component.TransactionForm;
import com.retro.web.bean.Transaction;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * @author Vinayak More
 *
 * @date 18-Apr-2017
 */
@SpringView(name = TransactionView.NAME)
public class TransactionView extends AbstractView<TransactionController> {

    private static final long serialVersionUID = 1L;
    public static final String NAME = "transactions";
    private VerticalLayout layout;
    private Button add;
    @Autowired
    private TransactionForm form;
    private Grid<Transaction> grid = new Grid<>(Transaction.class);

    @PostConstruct
    public void init() {
        layout = new VerticalLayout();// .getCustomLayout("transaction-view");
        initComponent();
        addComponent();

    }

    private void initComponent() {
        grid.setColumns("symbol", "transactionTime", "quantity", "pricePerStock", "priceInTotal");
        grid.setSizeFull();
        form.setVisible(false);
        add = new Button("Add", e -> {
            form.setVisible(true);
            form.setBean(new Transaction());
        });
        add.addStyleName(ValoTheme.BUTTON_PRIMARY);
    }

    private void addComponent() {
        layout.addComponent(add);
        HorizontalLayout horizontalLayout = new HorizontalLayout(grid, form);
//        horizontalLayout.setExpandRatio(form, 1);
        horizontalLayout.setSizeFull();
        layout.addComponents(horizontalLayout);
        layout.setExpandRatio(horizontalLayout, 1.0F);

    }

    public void setList(List<Transaction> transactionList) {
        grid.setItems(transactionList);
    }

    @Override
    protected Component getComponent() {
        return layout;
    }

}
