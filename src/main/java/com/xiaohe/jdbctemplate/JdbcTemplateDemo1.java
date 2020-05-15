package com.xiaohe.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateDemo1 {

    public static void main(String[] args) {
        //准备数据
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/sys");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("123456");


        //创建jdbc对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        jdbcTemplate.setDataSource(driverManagerDataSource);
        //2 执行操作
        jdbcTemplate.execute("insert into account(name,money)values('cccc',100);");
    }
}
