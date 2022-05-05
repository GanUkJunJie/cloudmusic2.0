package com.example.cloudmusic.serviceImpl;

import com.example.cloudmusic.dao.UserInfoDao;
import com.example.cloudmusic.entity.UserBase;
import com.example.cloudmusic.entity.UserInfo;
import com.example.cloudmusic.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoDao userInfoDao;

    public UserInfo getUserInfo(String uuid) {
        return userInfoDao.getUserInfo(uuid);
    }

    public void updateUserInfo(String uuid, String name, String sex,
        String intro,Integer birthYear,Integer birthMonth,
        Integer birthDay, String address, String avatar){
        userInfoDao.updateUserInfo(uuid,name,sex,intro,birthYear,birthMonth,birthDay,address,avatar);
    }

    public UserBase getUserBase(String uuid){
        return userInfoDao.getUserBase(uuid);
    }
}
