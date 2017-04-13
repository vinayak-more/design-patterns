package com.retro.web.repository.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.retro.web.bean.Investment;
import com.retro.web.repository.PortfolioRepository;

/**
 * @author Vinayak More
 *
 * @date 11-Apr-2017
 */
@Component
public class PortfolioRepositoryJdbcImpl implements PortfolioRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Investment> getAllInvestments(Long userId) {
        String query = "SELECT * FROM `user_folio` WHERE `user_id`=?";
        List<Investment> investmentList = new ArrayList<Investment>();
        try {
            investmentList = jdbcTemplate.query(query, new RowMapper<Investment>() {

                @Override
                public Investment mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Investment investment = new Investment();
                    investment.setRid(rs.getLong("rid"));
                    investment.setUserId(rs.getLong("user_id"));
                    investment.setSymbol(rs.getString("symbol"));
                    investment.setQuantity(rs.getInt("quantity"));
                    investment.setInvestment(rs.getDouble("investment"));
                    investment.setCurrentValue(rs.getDouble("current_value"));
                    investment.setChangeValue(rs.getDouble("change_value"));
                    investment.setChangePercentage(rs.getDouble("change_percent"));
                    investment.setTodaysGain(rs.getDouble("todays_gain"));
                    investment.setLasUpdated(rs.getTimestamp("last_updated"));
                    return investment;
                }
            }, userId);
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return investmentList;
    }

    @Override
    public boolean updateAllInvestments(Collection<Investment> investmentList) {
        if (CollectionUtils.isEmpty(investmentList)) {
            return false;
        }
        for (Investment investment : investmentList) {
            if (isInvestmentExists(investment)) {
                if (investment.getQuantity() > 0) {
                    updateInvestment(investment);
                } else {
                    deleteInvestment(investment);
                }
            } else {
                saveInvestment(investment);
            }

        }
        return true;
    }

    private void deleteInvestment(final Investment investment) {
        String query = "DELETE FROM `user_folio` WHERE `symbol`=?";
        try {
            jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

                @Override
                public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                    ps.setString(1, investment.getSymbol());
                    return !ps.execute();
                }
            });
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private void updateInvestment(final Investment investment) {
        final Long rid = getInvestmentRid(investment);
        String query =
                "UPDATE `user_folio` "
                        + "SET `quantity`=?,`investment`=?,`current_value`=?,`change_value`=?,`change_percent`=?,`todays_gain`=?,"
                        + "`last_updated`=? WHERE `rid`=?";
        try {
            jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

                @Override
                public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                    ps.setInt(1, investment.getQuantity());
                    ps.setDouble(2, investment.getInvestment());
                    ps.setDouble(3, investment.getCurrentValue());
                    ps.setDouble(4, investment.getChangeValue());
                    ps.setDouble(5, investment.getChangePercentage());
                    ps.setDouble(6, investment.getTodaysGain());
                    ps.setTimestamp(7, new Timestamp(investment.getLasUpdated().getTime()));
                    ps.setLong(8, rid);
                    System.out.println(ps);
                    return !ps.execute();
                }
            });
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private void saveInvestment(final Investment investment) {
        String query =
                "INSERT INTO `user_folio` (`user_id`,`symbol`,`quantity`,`investment`,"
                        + "`current_value`,`change_value`,`change_percent`,`todays_gain`,`last_updated`) "
                        + "VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

                @Override
                public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                    ps.setLong(1, investment.getUserId());
                    ps.setString(2, investment.getSymbol());
                    ps.setInt(3, investment.getQuantity());
                    ps.setDouble(4, investment.getInvestment());
                    ps.setDouble(5, investment.getCurrentValue());
                    ps.setDouble(6, investment.getChangeValue());
                    ps.setDouble(7, investment.getChangePercentage());
                    ps.setDouble(8, investment.getTodaysGain());
                    ps.setTimestamp(9, new Timestamp(investment.getLasUpdated().getTime()));
                    System.out.println(ps);
                    return !ps.execute();
                }
            });
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isInvestmentExists(Investment investment) {
        Long rid = 0L;
        String query = "SELECT `rid` FROM `user_folio` WHERE `symbol` =?";
        try {
            rid = jdbcTemplate.queryForObject(query, new Object[] {investment.getSymbol()}, Long.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rid > 0;
    }

    private Long getInvestmentRid(Investment investment) {
        Long rid = 0L;
        String query = "SELECT `rid` FROM `user_folio` WHERE `symbol` =?";
        try {
            rid = jdbcTemplate.queryForObject(query, new Object[] {investment.getSymbol()}, Long.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rid;
    }

}
