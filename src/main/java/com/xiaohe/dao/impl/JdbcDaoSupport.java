package com.xiaohe.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 父类
 *
 * 为子类 DaoImpl  提供接口
 */
public class JdbcDaoSupport {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }


    public void setDataSource(DataSource dataSource) {
        if(jdbcTemplate == null){
            jdbcTemplate = createJdbcTemplate(dataSource);
        }
    }

    private JdbcTemplate createJdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

}
