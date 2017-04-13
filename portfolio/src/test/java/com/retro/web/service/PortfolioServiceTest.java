package com.retro.web.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.retro.config.JavaConfig;

@ContextConfiguration(classes = JavaConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("classpath:test.properties")
public class PortfolioServiceTest {

    @Autowired
    private PortfolioService service;
    
    @Test
    public void shouldNotBeNull(){
        Assert.assertNotNull(service);
    }
    
    @Test
    public void testInvestmentRefresh(){
        Assert.assertTrue(service.refreshInvestmentData(8L));
    }
    
    @Test
    public void testAllInvestments(){
        Assert.assertFalse(service.getAllInvestments(8L).isEmpty());
    }
    
}
