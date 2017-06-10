package com.retro.web.repository.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.retro.vaadin.module.login.bean.UserRegistrationBean;
import com.retro.web.bean.RegisterUser;
import com.retro.web.bean.User;
import com.retro.web.repository.UserRepository;
import com.retro.web.repository.impl.mapper.UserRowMapper;
import com.retro.web.utils.PasswordUtils;

/**
 * @author Vinayak More
 *
 * @date 08-Apr-2017
 */
@Repository
public class UserRepositoryJdbcImpl implements UserRepository {

	private static final Logger logger = LoggerFactory
			.getLogger(UserRepositoryJdbcImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean saveUser(final User user) {
		String query = "INSERT INTO user(`username`,`password`) values (?,?)";
		try {
			Boolean execute = jdbcTemplate.execute(query,
					new PreparedStatementCallback<Boolean>() {

						@Override
						public Boolean doInPreparedStatement(
								PreparedStatement ps) throws SQLException,
								DataAccessException {
							ps.setString(1, user.getUsername());
							ps.setString(2,
									PasswordUtils.getHash(user.getPassword()));
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

	@Override
	public User isValidUser(final String username, String password) {
		String query = "SELECT * FROM `user` WHERE `username`=? AND `password`=?";
		User user = null;
		try {
			user = jdbcTemplate.queryForObject(query, new RowMapper<User>() {

				@Override
				public User mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					User user = new User(username, "");
					user.setUserId(rs.getLong("user_id"));
					return user;
				}
			}, username, PasswordUtils.getHash(password));
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean register(RegisterUser user) {
		boolean success = false;
		final String sqlUser = "INSERT INTO `user` (`username`,`password`) values (?,?)";
		final String sql = "INSERT INTO `user_basic_details` (`user_id`,`name`,`email`,`mobile`) values (?,?,?,?)";
		String password = PasswordUtils.getHash(user.getPassword());
		try {
			jdbcTemplate.update(sqlUser, user.getUsername(), password);
			User user1 = isValidUser(user.getUsername(), user.getPassword());
			jdbcTemplate.update(sql, user1.getUserId(), user.getName(),
					user.getEmail(), user.getMobile());
			success = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public boolean register(UserRegistrationBean bean) {
		String password = PasswordUtils.getHash(bean.getPassword());
		String pin = PasswordUtils.getHash(bean.getRecoveryPin().toString());

		try {
			jdbcTemplate.update(SQLConstants.INSERT_USER, bean.getUsername(),
					password, pin);
			bean.setUserId(getUserByUsername(bean.getUsername()).getUserId());
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public User getUserByUsername(String username) {
		User user = null;
		try {
			user = jdbcTemplate.queryForObject(SQLConstants.USER_BY_USERNAME,
					new UserRowMapper(), username);
		} catch (DataAccessException e) {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
