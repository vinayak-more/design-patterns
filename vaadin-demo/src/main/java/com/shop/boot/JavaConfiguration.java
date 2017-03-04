/**
 * @author Vinayak More
 *
 * @date 04-Mar-2017
 */
package com.shop.boot;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.shop.DemoApplication;

@Configuration
@ComponentScan(basePackageClasses={DemoApplication.class})
@PropertySource("classpath:application.properties")
public class JavaConfiguration {
    
    @Autowired
    Environment env;
    
    @Bean
    public DataSource getMySQLDriverManagerDatasource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("db.diver.class.name"));
        dataSource.setPassword(env.getProperty("db.password"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.username"));
        return dataSource;
    }
    
    @Bean
    public JdbcTemplate jbJdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
