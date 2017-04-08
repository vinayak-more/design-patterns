package com.retro.web.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.retro.config.JavaConfig;

/**
 * @author Vinayak More
 *
 * @date 08-Apr-2017
 */
@ContextConfiguration(classes=JavaConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("classpath:test.properties")
public class UserRepositoryTest {
    
    @Autowired
    JdbcTemplate template;
    
    @Test
    public void testInit(){
        Assert.assertNotNull(template);
    }

}

