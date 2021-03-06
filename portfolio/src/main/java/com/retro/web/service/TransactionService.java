package com.retro.web.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retro.rest.bean.StockQoute;
import com.retro.rest.client.GoogleFinanceRestClient;
import com.retro.web.bean.Stock;
import com.retro.web.bean.Transaction;
import com.retro.web.repository.StockRepository;
import com.retro.web.repository.TransactionRepository;
import com.retro.web.utils.MyDateUtils;

/**
 * @author Vinayak More
 *
 * @date 09-Apr-2017
 */
@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private GoogleFinanceRestClient restClient;

    public boolean saveTransaction(Transaction transaction) {
        prepareTransaction(transaction);
        return repository.saveTransaction(transaction);
    }

    public boolean updateTransaction(Transaction transaction) {
        prepareTransaction(transaction);
        return repository.updateTransaction(transaction);
    }

    public boolean deleteTransaction(Long rid) {
        return repository.deleteTransaction(rid);
    }

    public List<Transaction> getAllTransaction(Long userId) {
        return repository.getAllTransactions(userId);
    }

    private void prepareTransaction(Transaction transaction) {
        int quantity = transaction.getQuantity();
        double pricePerStock = transaction.getPricePerStock();
        double totalPrice = quantity * pricePerStock;
        Stock key = transaction.getStock();
        String symbol = key.getSymbol();
        if (StringUtils.isEmpty(key.getSymbol())) {
            symbol = key.getCode();
        }
        transaction.setSymbol(symbol);
        transaction.setPriceInTotal(totalPrice);
        transaction.setTransactionTime(MyDateUtils.getDateWithoutTime(transaction.getTransactionTime()));
    }

    public double getCurrentPriceForStock(Stock stock) {
        double price = 0;
        StockQoute qoute;
        try {
            qoute = restClient.getNSEQoute(stock.getSymbol()).getStockQoute();
            price = qoute.getCurrentPrice();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return price;
    }

}
