package com.retro.rest.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import com.retro.rest.bean.Quote;

/**
 * @author Vinayak More
 *
 * @date 08-Apr-2017
 */
@Component
public class GoogleFinanceRestClient {

    @Autowired
    private RestOperations restOperations;
    private final String url;

    @Autowired
    public GoogleFinanceRestClient(@Value("${google.finance.url}") String url) {
        this.url = url;

    }

    public Quote getNSEQuote(final String symbol) {
        try {
            return restOperations.getForObject(url, Quote.class, symbol);
        } catch (Exception e) {
            return new Quote();
        }
    }

    public Quote getBSEQoute(String symbol) {
        return null;
    }
}
