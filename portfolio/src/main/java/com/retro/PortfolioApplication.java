package com.retro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.retro.rest.client.GoogleFinanceRestClient;

@SpringBootApplication
public class PortfolioApplication implements CommandLineRunner{

    
    private static final Logger logger = LoggerFactory.getLogger(PortfolioApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}

	@Autowired
	private GoogleFinanceRestClient client;
    
    @Override
    public void run(String... args) throws Exception {
       logger.info( client.getQoute("ICICIPRULI").toString());
       logger.info( client.getQoute("AXISBANK").toString());
    }
}
