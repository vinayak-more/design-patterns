package com.retro.web.repository.impl.mapper;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.PreparedStatementSetter;

import com.retro.web.bean.Transaction;

/**
 * @author Vinayak More
 *
 * @date 28-Apr-2017
 */
public class TransactionPreparedStatementSetter implements PreparedStatementSetter {

    private Transaction transaction;

    public TransactionPreparedStatementSetter(Transaction transaction) {
        this.transaction = transaction;

    }

    @Override
    public void setValues(PreparedStatement ps) throws SQLException {
        ps.setTimestamp(1, new Timestamp(transaction.getTransactionTime().getTime()));
        ps.setString(2, transaction.getType().toString());
        ps.setString(3, transaction.getMarket().toString());
        ps.setString(4, transaction.getSymbol());
        ps.setInt(5, transaction.getQuantity());
        ps.setDouble(6, transaction.getPricePerStock());
        ps.setDouble(7, transaction.getPriceInTotal());
        ps.setTimestamp(8, new Timestamp(transaction.getLastmodDatetime().getTime()));
        ps.setLong(9, transaction.getRid());
    }
}
