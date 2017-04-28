package com.retro.web.repository.impl.mapper;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.retro.web.bean.Transaction;

/**
 * @author Vinayak More
 *
 * @date 28-Apr-2017
 */
public class TransactionPreparedStatementCallback implements PreparedStatementCallback<Boolean> {

    private Transaction transaction;

    public TransactionPreparedStatementCallback(Transaction transaction) {
        this.transaction = transaction;

    }

    @Override
    public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
        ps.setLong(1, transaction.getUserId());
        ps.setTimestamp(2, new Timestamp(transaction.getTransactionTime().getTime()));
        ps.setString(3, transaction.getType().toString());
        ps.setString(4, transaction.getMarket().toString());
        ps.setString(5, transaction.getSymbol());
        ps.setInt(6, transaction.getQuantity());
        ps.setDouble(7, transaction.getPricePerStock());
        ps.setDouble(8, transaction.getPriceInTotal());
        ps.setTimestamp(9, new Timestamp(transaction.getCreationDatetime().getTime()));
        ps.setTimestamp(10, new Timestamp(transaction.getLastmodDatetime().getTime()));
        return !ps.execute();
    }
}

