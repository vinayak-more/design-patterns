package com.retro.web.pool;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.retro.web.pool.bean.StockDataPool;
import com.retro.web.pool.service.PoolDataService;

/**
 * @author Vinayak More
 *
 * @date 07-Aug-2017
 */
@Component
public class PooledLauncher {

    @Autowired
    private PoolDataService service;

    @Autowired
    private PooledDataExecutor executor;

    @Autowired
    private StockDataPool pool;

    @PostConstruct
    public void init() {
        service.updateInMemoryStockSymbols();;
        executor.execute(pool.getListedStocks());
    }

    public Runnable launch() {
        return new Runnable() {

            @Override
            public void run() {
                init();
            }
        };
    }
}
