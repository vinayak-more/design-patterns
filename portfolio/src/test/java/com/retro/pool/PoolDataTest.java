package com.retro.pool;


import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.retro.config.JavaConfig;
import com.retro.web.pool.PooledLauncher;
import com.retro.web.pool.bean.StockDataPool;

/**
 * @author Vinayak More
 *
 * @date 07-Aug-2017
 */
@ContextConfiguration(classes = JavaConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations = "classpath:test.properties")
public class PoolDataTest {
    
    @Autowired
    private PooledLauncher launcher;
    
    @Autowired
    private StockDataPool pool;
    
    @Test
    public void shouldNotBeNull(){
        assertNotNull(launcher);
        assertNotNull(pool);
    }
    
    @Test
    public void getAllStocksAddedByUsers(){
        Set<String> listedStocks = pool.getListedStocks();
        System.out.println("*******************************\n"+listedStocks+"\n***************************");
        assertNotNull(listedStocks);
    }
    
}

