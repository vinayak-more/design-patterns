package com.retro.web.repository.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Component;

import com.retro.web.bean.Transaction;
import com.retro.web.repository.TransactionRepository;

/**
 * @author Vinayak More
 *
 * @date 09-Apr-2017
 */
@Component
public class TransactionRepositoryJdbcImpl implements TransactionRepository {


    private static final Logger logger = LoggerFactory.getLogger(TransactionRepositoryJdbcImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean saveTransaction(final Transaction transaction) {

        String query =
                "INSERT INTO `user_transaction` "
                        + "(`user_id`,`transaction_date`,`type`,`market`,`symbol`,`quantity`,`price_per_stock`,`price_in_total`,`create_datetime`,`last_mod_datetime`)"
                        + " values (?,?,?,?,?,?,?,?,?,?)";
        try {
            Boolean success = jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

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
            });
            return success.booleanValue();
        } catch (Exception e) {
            logger.error("Exception while saving Transaction", e);
        }
        return false;
    }

}
