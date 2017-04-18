package com.retro.vaadin.module.transaction.delegate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.retro.vaadin.kit.AbstractDelegate;
import com.retro.web.bean.Transaction;
import com.retro.web.service.TransactionService;

/**
 * @author Vinayak More
 *
 * @date 18-Apr-2017
 */
@Component
public class TransactionDelegate extends AbstractDelegate {

    @Autowired
    private TransactionService service;

    public List<Transaction> getAllTransaction() {
        return service.getAllTransaction(getUserId());
    }

}
