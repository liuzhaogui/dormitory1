package com.service;

import com.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

        private UserDao userDao;

        @Autowired
        public void setUserDao(UserDao userDao){
            this.userDao=userDao;
        }

        public boolean Match(int st_id,String password){
                int count=userDao.FindUser(st_id,password);
                return count>0;
        }
}
