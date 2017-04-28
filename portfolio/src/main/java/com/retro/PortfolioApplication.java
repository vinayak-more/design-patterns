package com.retro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.retro.rest.client.GoogleFinanceRestClient;

@SpringBootApplication
public class PortfolioApplication{

    
	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}

	@Autowired
	private GoogleFinanceRestClient client;
    
    
}
