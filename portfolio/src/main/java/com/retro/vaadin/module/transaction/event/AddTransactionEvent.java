package com.retro.vaadin.module.transaction.event;

import com.retro.web.bean.Transaction;

/**
 * @author Vinayak More
 *
 * @date 29-Apr-2017
 */
public class AddTransactionEvent {

    private final Transaction bean;

    public AddTransactionEvent(Transaction bean) {
        this.bean = bean;
    }

    public Transaction getBean() {
        return bean;
    }
    
    

}
