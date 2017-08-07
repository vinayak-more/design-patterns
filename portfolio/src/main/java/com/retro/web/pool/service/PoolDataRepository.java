package com.retro.web.pool.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author Vinayak More
 *
 * @date 07-Aug-2017
 */
@Repository
public class PoolDataRepository {

    @Autowired
    private JdbcTemplate template;

    public List<String> getAllStocksAddedByUsers() {
        String query = "SELECT distinct `symbol` FROM `user_folio`";
        List<String> stocksAddedByUser = template.queryForList(query, String.class);
        if (CollectionUtils.isNotEmpty(stocksAddedByUser)) {
            return stocksAddedByUser;
        }
        return new ArrayList<String>();
    }

}
