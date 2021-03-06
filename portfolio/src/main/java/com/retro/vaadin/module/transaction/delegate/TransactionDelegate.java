package com.retro.vaadin.module.transaction.delegate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.retro.vaadin.kit.AbstractDelegate;
import com.retro.web.bean.Stock;
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

    public void save(Transaction bean) {
        bean.setUserId(getUserId());
        service.saveTransaction(bean);
    }

    public double getCurrentPriceForStock(Stock stock) {
        return service.getCurrentPriceForStock(stock);
    }

    public boolean update(Transaction bean) {
        return service.updateTransaction(bean);
        
    }

    public boolean delete(Transaction bean) {
        return service.deleteTransaction(bean.getRid());
    }

}
