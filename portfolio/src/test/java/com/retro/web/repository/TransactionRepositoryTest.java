package com.retro.web.repository;


import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.retro.config.JavaConfig;
import com.retro.web.bean.Constants.Market;
import com.retro.web.bean.Transaction;
import com.retro.web.bean.Transaction.Type;
import com.retro.web.service.TransactionService;

/**
 * @author Vinayak More
 *
 * @date 09-Apr-2017
 */
@ContextConfiguration(classes = JavaConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("classpath:test.properties")
public class TransactionRepositoryTest {
    
    @Autowired
    private Environment env;

    @Autowired
    private TransactionService service;

    @Test
    public void shouldNotBeNull() {
        Assert.assertNotNull(service);
    }
    @Test
    public void saveTransactionTest(){
        Assert.assertTrue(service.saveTransaction(getTestTransaction()));
    }
    
    public void updateTransaction(){
        Assert.assertTrue(service.updateTransaction(getTestTransaction()));
    }
    
    public void deleteTransaction(){
        Assert.assertTrue(service.deleteTransaction(1L));
    }
    
    public void getAllTransaction(){
        List<Transaction> allTransaction = service.getAllTransaction(8L);
        System.out.println();
        System.out.println(allTransaction);
        System.out.println();
        Assert.assertTrue(!allTransaction.isEmpty());
    }

    private Transaction getTestTransaction() {
        Transaction t=new Transaction();
        t.setRid(1L);
        t.setUserId(8l);
        t.setTransactionTime(new Date());
        t.setType(Type.SELL);
        t.setMarket(Market.NSE);
        t.setSymbol(env.getProperty("quote.key"));
        t.setQuantity(1);
        t.setPricePerStock(100D);
        t.setPriceInTotal(100D);
        return t;
    }

}
