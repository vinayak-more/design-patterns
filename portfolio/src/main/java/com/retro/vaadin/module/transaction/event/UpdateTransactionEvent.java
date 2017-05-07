package com.retro.vaadin.module.transaction.event;

import com.retro.web.bean.Transaction;

/**
 * @author Vinayak More
 *
 * @date 05-May-2017
 */
/**
 * @author Vinayak More
 *
 * @date 05-May-2017
 */
public class UpdateTransactionEvent {

    private final Transaction bean;

    public UpdateTransactionEvent(Transaction bean) {
        this.bean = bean;
    }

    public Transaction getBean() {
        return bean;
    }


}
