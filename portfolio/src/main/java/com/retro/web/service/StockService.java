package com.retro.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retro.web.bean.Stock;
import com.retro.web.repository.StockRepository;

/**
 * @author Vinayak More
 *
 * @date 23-Apr-2017
 */
@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    public List<Stock> getStockByPrefix(String prefix) {
        return repository.getStocksByPrefix(prefix);
    }
}
