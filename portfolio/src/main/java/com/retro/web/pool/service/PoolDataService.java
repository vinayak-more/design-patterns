package com.retro.web.pool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retro.web.pool.bean.StockDataPool;

/**
 * @author Vinayak More
 *
 * @date 07-Aug-2017
 */
@Service
public class PoolDataService {
    
    @Autowired
    private PoolDataRepository repository;
    
    @Autowired
    private StockDataPool pool;

    public void updateInMemoryStockSymbols() {
        List<String> list=repository.getAllStocksAddedByUsers();
        pool.getListedStocks().addAll(list);
    }

}

