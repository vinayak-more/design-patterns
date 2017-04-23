package com.retro.web.repository.mapper;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementSetter;

/**
 * @author Vinayak More
 *
 * @date 23-Apr-2017
 */
public class StockPreparedStatementSetter implements PreparedStatementSetter{

    private String prefix;

    public StockPreparedStatementSetter(String prefix) {
        super();
        this.prefix = prefix;
    }

    @Override
    public void setValues(PreparedStatement ps) throws SQLException {
        ps.setString(1, "%"+prefix+"%");
        ps.setString(2, "%"+prefix+"%");
        ps.setString(3, "%"+prefix+"%");
        
    }

}
