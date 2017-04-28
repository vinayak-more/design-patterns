package com.retro.vaadin.module.transaction;

import java.util.List;

import javax.annotation.PostConstruct;

import com.retro.vaadin.kit.TemplateLayoutFactory;
import com.retro.vaadin.kit.uihelper.view.AbstractView;
import com.retro.web.bean.Transaction;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomLayout;

/**
 * @author Vinayak More
 *
 * @date 18-Apr-2017
 */
@SpringView(name = TransactionView.NAME)
public class TransactionView extends AbstractView<TransactionController> {

    private static final long serialVersionUID = 1L;
    public static final String NAME = "transactions";
    private CustomLayout layout;

    @PostConstruct
    public void init() {
        layout = TemplateLayoutFactory.getCustomLayout("transaction-view");
        initComponent();
        addComponent();

    }

    private void initComponent() {
    }

    private void addComponent() {
    }

    public void setList(List<Transaction> transactionList) {
    }

    @Override
    protected Component getComponent() {
        return layout;
    }

}
