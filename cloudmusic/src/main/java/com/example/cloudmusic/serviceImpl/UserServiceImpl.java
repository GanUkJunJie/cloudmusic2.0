package com.example.cloudmusic.serviceImpl;

import com.example.cloudmusic.dao.UserDao;
import com.example.cloudmusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public String login(String tel) {
        return userDao.login(tel);
    }

    @Override
    public void register(String tel, String pwd) {
        userDao.register(tel,pwd);
    }

    @Override
    public Boolean isExist(String tel) {
        return userDao.isExist(tel);
    }
}
