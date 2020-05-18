package com.xiaohe.test;

import com.xiaohe.dao.Dao;
import com.xiaohe.domain.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class TestDao {


    @Test
    public void t(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bena.xml");
        Dao dao = (Dao) applicationContext.getBean("dao");
        System.out.println("获取成功");
        Account account = dao.findAccountById(1);
        System.out.println(account);
        account.setMoney(1f);
        dao.updateAccount(account);
        System.out.println(account);
    }

    @Test
    public void t1(){
        //1.获取容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bena.xml");
        //2.获取对象
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate",JdbcTemplate.class);
        //3.执行操作
        //保存
//       jt.update("insert into account(name,money)values(?,?)","eee",3333f);
        //更新
//        jt.update("update account set name=?,money=? where id=?","test",4567,7);
        //删除
//        jt.update("delete from account where id=?",8);
        //查询所有
 //      List<Account> accounts = jt.query("select * from account where money > ?",new AccountRowMapper(),1000f);
        List<Account> accounts5 = jdbcTemplate.query("select * from account where money > ?",new BeanPropertyRowMapper<Account>(Account.class),1f);
        for(Account account5 : accounts5){
          System.out.println(account5);
      }
        //查询一个
      // List<Account> accounts6 = jdbcTemplate.query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),1);
      //  System.out.println(accounts6.isEmpty()?"没有内容":accounts6.get(0));

        //查询返回一行一列（使用聚合函数，但不加group by子句）
//        Long count = jt.queryForObject("select count(*) from account where money > ?",Long.class,1000f);
 //       System.out.println(count);

    }
}
