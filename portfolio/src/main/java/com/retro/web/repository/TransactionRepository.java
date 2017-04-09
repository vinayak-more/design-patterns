package com.retro.web.repository;

import com.retro.web.bean.Transaction;

/**
 * @author Vinayak More
 *
 * @date 09-Apr-2017
 */
public interface TransactionRepository {
    
    public boolean saveTransaction(Transaction transaction);
    
    public boolean updateTransaction(Transaction transaction);
    

}

