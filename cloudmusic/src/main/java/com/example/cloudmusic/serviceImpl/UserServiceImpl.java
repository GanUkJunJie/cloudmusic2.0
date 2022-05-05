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
    public void register(String uuid,String tel, String password) {
        userDao.register(uuid,tel,password);
    }

    @Override
    public Integer isExist(String tel) {
        return userDao.isExist(tel);
    }

    @Override
    public String getUUID(String tel) {
        return userDao.getUUID(tel);
    }
}
