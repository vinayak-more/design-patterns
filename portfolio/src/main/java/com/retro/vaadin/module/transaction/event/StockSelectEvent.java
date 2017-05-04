package com.retro.vaadin.module.transaction.event;

import com.retro.vaadin.module.transaction.component.TransactionForm;
import com.retro.web.bean.Stock;

/**
 * @author Vinayak More
 *
 * @date 04-May-2017
 */
public class StockSelectEvent {

    private final Stock stock;
    private final TransactionForm view;

    public StockSelectEvent(Stock stock, TransactionForm view) {
        this.stock = stock;
        this.view = view;
    }

    public Stock getStock() {
        return stock;
    }

    public TransactionForm getView() {
        return view;
    }



}
