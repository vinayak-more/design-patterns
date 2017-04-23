package com.retro.web.repository;

import java.util.List;

import com.retro.web.bean.Stock;

/**
 * @author Vinayak More
 *
 * @date 22-Apr-2017
 */
public interface StockRepository {

    public List<Stock> getStocksByPrefix(String prefix);
}
