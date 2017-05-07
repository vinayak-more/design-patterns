package com.retro.vaadin.module.transaction.event;

import com.retro.web.bean.Transaction;

/**
 * @author Vinayak More
 *
 * @date 07-May-2017
 */
public class DeleteTransactionEvent {

    private final Transaction bean;

    public DeleteTransactionEvent(Transaction bean) {
        this.bean = bean;
    }

    public Transaction getBean() {
        return bean;
    }
}
