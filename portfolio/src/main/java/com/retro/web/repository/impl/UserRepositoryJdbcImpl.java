package com.retro.web.repository.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Component;

import com.retro.web.bean.User;
import com.retro.web.repository.UserRepository;
import com.retro.web.utils.PasswordUtils;

/**
 * @author Vinayak More
 *
 * @date 08-Apr-2017
 */
@Component
public class UserRepositoryJdbcImpl implements UserRepository {


    private static final Logger logger = LoggerFactory.getLogger(UserRepositoryJdbcImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PasswordUtils passwordUtils;


    public boolean saveUser(final User user) {
        String query = "INSERT INTO user(`username`,`password`) values (?,?)";
        try {
            Boolean execute = jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

                @Override
                public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                    ps.setString(1, user.getUsername());
                    ps.setString(2, passwordUtils.getHash(user.getPassword()));
                    logger.info(ps.toString());
                    return !ps.execute();
                }
            });
            return execute.booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception while saving User", e);
            return false;
        }
    }



}
