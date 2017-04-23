package com.retro.web.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.retro.config.JavaConfig;
import com.retro.web.bean.Stock;

/**
 * @author Vinayak More
 *
 * @date 23-Apr-2017
 */
@ContextConfiguration(classes = JavaConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("classpath:test.properties")
public class StockServiceTest {
    
    @Autowired
    private StockService service;
    
    @Test
    public void shouldNotBeNull(){
        Assert.assertNotNull(service);
    }

    @Test
    public void testStockListByPrefix(){
        List<Stock> stockByPrefix = service.getStockByPrefix("ICICIPRULI");
        System.out.println();
        System.out.println(stockByPrefix);
        System.out.println();
        Assert.assertTrue(stockByPrefix.size()>0);
    }
}
