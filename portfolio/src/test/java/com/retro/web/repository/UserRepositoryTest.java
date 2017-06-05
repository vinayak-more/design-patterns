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
import com.retro.web.bean.RegisterUser;
import com.retro.web.bean.User;

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
    private JdbcTemplate template;
    
    @Autowired
    private UserRepository repository;
    
    @Test
    public void testInit(){
        Assert.assertNotNull(template);
    }
    
    public void testSaveUser(){
        Assert.assertTrue(repository.saveUser(new User("vinayak", "welcome")));
    }
    
    @Test
    public void testUserLogin(){
        Assert.assertNotNull(repository.isValidUser("vinayak", "welcome"));
    }
    
    @Test
    public void testNewUserRegister(){
    	RegisterUser r= new RegisterUser();
    	r.setName("Vinayak");
    	r.setUsername("vinayak0914");
    	r.setPassword("vinayak@0914");
    	r.setEmail("vinayak.more@yopmail.com");
    	r.setMobile("9988776655");
    	Assert.assertTrue(repository.register(r));
    	
    }

}

