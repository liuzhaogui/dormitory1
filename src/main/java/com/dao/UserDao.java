package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

        private JdbcTemplate jdbcTemplate;

        //sql语句
        private final  static String sql="SELECT COUNT(*) FROM st_login WHERE st_id=? AND PASSWORD=?";

        @Autowired
        public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
            this.jdbcTemplate=jdbcTemplate;
        }

        public int FindUser(int st_id,String password){
            return jdbcTemplate.queryForObject(sql,new Object[]{st_id,password},Integer.class);
        }
}
