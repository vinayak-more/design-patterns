package com.retro.web.repository.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.retro.web.bean.Transaction;
import com.retro.web.repository.StockRepository;
import com.retro.web.repository.TransactionRepository;
import com.retro.web.repository.impl.mapper.TransactionPreparedStatementCallback;
import com.retro.web.repository.impl.mapper.TransactionPreparedStatementSetter;
import com.retro.web.repository.impl.mapper.TransactionRowMapper;

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

    @Autowired
    private StockRepository stockRepository;

    @Override
    public boolean saveTransaction(final Transaction transaction) {

        String query =
                "INSERT INTO `user_transaction` "
                        + "(`user_id`,`transaction_date`,`type`,`market`,`symbol`,`quantity`,`price_per_stock`,`price_in_total`,`create_datetime`,`last_mod_datetime`,`stock_id`)"
                        + " values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            Boolean success = jdbcTemplate.execute(query, new TransactionPreparedStatementCallback(transaction));
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
                        + " SET `transaction_date`=?,`type`=?,`market`=?,`symbol`=?,`quantity`=?,`price_per_stock`=?,`price_in_total`=? ,`last_mod_datetime`=? ,`stock_id`=?"
                        + " WHERE `rid`=? ";
        try {
            jdbcTemplate.update(query, new TransactionPreparedStatementSetter(transaction));
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
            List<Transaction> transactionList = jdbcTemplate.query(query, new TransactionRowMapper(), userId);
            CollectionUtils.forAllDo(transactionList, new Closure<Transaction>() {

                @Override
                public void execute(Transaction t) {
                    t.setStock(stockRepository.getStocksByID(t.getStockId()));
                }
            });
            return transactionList;
        } catch (Exception e) {
            logger.error("Exception while retrieving Transactions for user_Id=" + userId, e);
        }
        return null;
    }

}
