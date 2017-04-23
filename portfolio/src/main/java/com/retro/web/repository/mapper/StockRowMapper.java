package com.retro.web.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.retro.web.bean.Stock;

/**
 * @author Vinayak More
 *
 * @date 23-Apr-2017
 */
public class StockRowMapper implements RowMapper<Stock> {


    @Override
    public Stock mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Stock(rs.getString("company"), rs.getString("bse_code"), rs.getString("nse_symbol"));
    }

}
