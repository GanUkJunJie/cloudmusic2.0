package com.example.cloudmusic.serviceImpl;

import com.example.cloudmusic.dao.UserBaseDao;
import com.example.cloudmusic.entity.UserBase;
import com.example.cloudmusic.service.UserBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBaseServiceImpl implements UserBaseService {
    @Autowired
    UserBaseDao userBaseDao;

    @Override
    public UserBase getUserBase(String uuid) {
        return userBaseDao.getUserBase(uuid);
    }
}
