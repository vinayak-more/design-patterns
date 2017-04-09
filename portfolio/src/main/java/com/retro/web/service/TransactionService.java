package com.retro.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.retro.web.bean.Transaction;
import com.retro.web.repository.TransactionRepository;
import com.retro.web.utils.MyDateUtils;

/**
 * @author Vinayak More
 *
 * @date 09-Apr-2017
 */
@Component
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    public boolean saveTransaction(Transaction transaction) {
        prepareTransaction(transaction);
        return repository.saveTransaction(transaction);
    }

    public boolean updateTransaction(Transaction transaction) {
        prepareTransaction(transaction);
        return repository.updateTransaction(transaction);
    }

    private void prepareTransaction(Transaction transaction) {
        int quantity = transaction.getQuantity();
        double pricePerStock = transaction.getPricePerStock();
        double totalPrice = quantity * pricePerStock;
        transaction.setPriceInTotal(totalPrice);
        transaction.setTransactionTime(MyDateUtils.getDateWithoutTime(transaction.getTransactionTime()));

    }
}
