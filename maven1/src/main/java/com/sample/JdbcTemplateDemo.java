package com.sample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcTemplateDemo {

    DataSource dataSource;

    // @Autowired
    JdbcTemplate jdbcTemplate;
    // NamedParameterJdbcTemplate namedParametersJdbcTemplate;
    
    @Autowired
    JdbcTemplateDemo(DataSource dataSource){
    	this.dataSource=dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        // namedParametersJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    Integer getCountofEmployees() {
        String qry = "select count(*) from employee";
        return jdbcTemplate.queryForObject(qry, Integer.class);
    }

}
