package com.liu.demo.service.impl;

import com.liu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void create(String name, Integer age,String userName) {
        jdbcTemplate.update("insert into USER(NAME, AGE,USERNAME) values(?, ?,?)", name, age,userName);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from USER where NAME = ?", name);
    }

    @Override
    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from USER", Integer.class);
    }

    @Override
    public void deleteUsersById(long id) {
        jdbcTemplate.update("delete from user where id = ?", id);
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver") ;
            String url = "jdbc:mysql://localhost:3306/zheng?serverTimezone=Asia/Shanghai&useSSL=false&characterEncoding=UTF-8" ;
            String username = "root" ;
            String password = "root" ;
            Connection con =
                    DriverManager.getConnection(url , username , password ) ;
            System.out.println(con);
            String sql = "select * from user";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rst = ps.executeQuery();
            while (rst.next()){
                //System.out.println(rst.getObject(0));
                System.out.println(rst.getObject(1));
                System.out.println(rst.getObject(2));
                System.out.println(rst.getObject(3));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
