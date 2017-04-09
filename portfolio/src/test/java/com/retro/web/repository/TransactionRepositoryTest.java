package com.retro.web.repository;


import java.util.Date;

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

    private Transaction getTestTransaction() {
        Transaction t=new Transaction();
        t.setUserId(8l);
        t.setTransactionTime(new Date());
        t.setType(Type.BUY);
        t.setMarket(Market.NSE);
        t.setSymbol(env.getProperty("quote.key"));
        t.setQuantity(1);
        t.setPricePerStock(400D);
        t.setPriceInTotal(400D);
        return t;
    }

}
