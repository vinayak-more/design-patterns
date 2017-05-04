package com.retro.web.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.retro.web.bean.Stock;
import com.retro.web.repository.StockRepository;
import com.retro.web.repository.mapper.StockPreparedStatementSetter;
import com.retro.web.repository.mapper.StockRowMapper;

/**
 * @author Vinayak More
 *
 * @date 23-Apr-2017
 */
@Repository
public class StockRepositoryJdbcImpl implements StockRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Stock> getStocksByPrefix(String prefix) {
        String sql = "SELECT * FROM `stock` WHERE `company` LIKE ? OR `bse_code` LIKE ? OR `nse_symbol` LIKE ?";
        List<Stock> query = null;
        try {
            query = jdbcTemplate.query(sql, new StockPreparedStatementSetter(prefix), new StockRowMapper());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return new ArrayList<Stock>();
        }

        return query;
    }

    @Override
    public Stock getStocksByID(int stockId) {
        String sql = "SELECT * FROM `stock` WHERE `id` = ?";
        Stock s = null;
        try {
            s = jdbcTemplate.queryForObject(sql, new StockRowMapper(), stockId);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return new Stock(0, "", "", "");
        }
        return s;
    }

}
