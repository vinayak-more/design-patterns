package com.retro.web.repository.impl.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.retro.web.bean.Constants;
import com.retro.web.bean.Transaction;

/**
 * @author Vinayak More
 *
 * @date 28-Apr-2017
 */
public class TransactionRowMapper implements RowMapper<Transaction> {


    @Override
    public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
        Transaction tx = new Transaction();
        tx.setRid(rs.getLong("rid"));
        tx.setUserId(rs.getLong("user_id"));
        tx.setTransactionTime(rs.getTimestamp("transaction_date"));
        tx.setType(rs.getString("type").equalsIgnoreCase(Transaction.Type.BUY.toString()) ? Transaction.Type.BUY
                : Transaction.Type.SELL);
        tx.setMarket(rs.getString("market").equalsIgnoreCase(Constants.Market.NSE.toString()) ? Constants.Market.NSE
                : Constants.Market.BSE);
        tx.setSymbol(rs.getString("symbol"));
        tx.setQuantity(rs.getInt("quantity"));
        tx.setPricePerStock(rs.getDouble("price_per_stock"));
        tx.setPriceInTotal(rs.getDouble("price_in_total"));
        tx.setCreationDatetime(rs.getTimestamp("create_datetime"));
        tx.setLastmodDatetime(rs.getTimestamp("last_mod_datetime"));
        return tx;
    }


}

