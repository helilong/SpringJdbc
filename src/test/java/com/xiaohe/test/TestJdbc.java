package com.xiaohe.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestJdbc {

    @Test
    public void T(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bena.xml");
        JdbcTemplate jdbcTemplate  = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        jdbcTemplate.execute("insert into account(name,money)values('dddd',100);");
    }
}
