package com.retro.web.repository.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.retro.web.bean.Constants;
import com.retro.web.bean.Transaction;
import com.retro.web.repository.TransactionRepository;

/**
 * @author Vinayak More
 *
 * @date 09-Apr-2017
 */
@Repository
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


    @Override
    public boolean updateTransaction(final Transaction transaction) {
        String query =
                "UPDATE `user_transaction` "
                        + "SET `transaction_date`=?,`type`=?,`market`=?,`symbol`=?,`quantity`=?,`price_per_stock`=?,`price_in_total`=? ,`last_mod_datetime`=? "
                        + "WHERE `rid`=?";
        try {
            jdbcTemplate.update(query, new PreparedStatementSetter() {

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
                    logger.info(ps.toString());
                }
            });
            return true;
        } catch (Exception e) {
            logger.error("Error while updating transaction with transaction id " + transaction.getRid(), e);
        }
        return false;
    }


    @Override
    public boolean deleteTransaction(final Long rid) {
        String query = "DELETE FROM `user_transaction` WHERE `rid`=?";
        try {
            Boolean success = jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

                @Override
                public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                    ps.setLong(1, rid);
                    return !ps.execute();
                }
            });
            return success.booleanValue();
        } catch (Exception e) {
            logger.error("Exception while deleting Transaction with rid=" + rid, e);
        }
        return false;
    }


    @Override
    public List<Transaction> getAllTransactions(Long userId) {
        String query = "SELECT * FROM `user_transaction` WHERE `user_id`=?";
        try {
            List<Transaction> transactionList = jdbcTemplate.query(query, new RowMapper<Transaction>() {

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
            }, userId);
            return transactionList;
        } catch (Exception e) {
            logger.error("Exception while retrieving Transactions for user_Id=" + userId, e);
        }
        return null;
    }

}
