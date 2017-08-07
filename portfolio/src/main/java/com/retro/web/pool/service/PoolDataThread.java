package com.retro.web.pool.service;

import java.util.List;

import com.retro.config.App;
import com.retro.rest.bean.Quote;
import com.retro.rest.client.GoogleFinanceRestClient;
import com.retro.web.pool.bean.PooledStockQuote;
import com.retro.web.pool.bean.StockDataPool;

/**
 * @author Vinayak More
 *
 * @date 07-Aug-2017
 */
public class PoolDataThread implements Runnable {

    private final List<String> stocks;

    private GoogleFinanceRestClient client = App.get(GoogleFinanceRestClient.class);
    private StockDataPool pool = App.get(StockDataPool.class);

    public PoolDataThread(List<String> stocks) {
        super();
        this.stocks = stocks;
    }

    @Override
    public void run() {
        for (String stock : stocks) {
            //get price
            Quote quote = client.getNSEQuote(stock);
            //map to domain object
            PooledStockQuote pooledQuote = new PooledStockQuote();
            pooledQuote.setSymbol(stock);
            pooledQuote.setCurrentPrice(Double.parseDouble(quote.getLFix()));
            pooledQuote.setLastClosePrice(Double.parseDouble(quote.getPclsFix()));
            //put value to in memory map
            pool.getPool().put(stock, pooledQuote);
        }
    }

}
