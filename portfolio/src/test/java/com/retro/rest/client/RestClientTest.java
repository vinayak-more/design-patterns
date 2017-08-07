package com.retro.rest.client;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.retro.config.JavaConfig;

/**
 * @author Vinayak More
 *
 * @date 08-Apr-2017
 */
@ContextConfiguration(classes = JavaConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations = "classpath:test.properties")
public class RestClientTest {

    @Autowired
    private Environment env;
    
    @Autowired
    private GoogleFinanceRestClient client;

    @Test
    public void test() {
        Assert.assertNotNull(client);
    }

    @Test
    public void testAPI() {
        Assert.assertNotNull(client.getNSEQuote(env.getProperty("quote.key")));
    }

}
