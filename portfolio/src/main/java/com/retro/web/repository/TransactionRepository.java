package com.retro.web.repository;

import java.util.List;

import com.retro.web.bean.Transaction;

/**
 * @author Vinayak More
 *
 * @date 09-Apr-2017
 */
public interface TransactionRepository {
    
    public boolean saveTransaction(Transaction transaction);
    
    public boolean updateTransaction(Transaction transaction);
    
    public boolean deleteTransaction(Long rid);
    
    public List<Transaction> getAllTransactions(String userId);

}

