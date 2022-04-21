package com.example.cloudmusic.serviceImpl;

import com.example.cloudmusic.dao.UserInfoDao;
import com.example.cloudmusic.entity.UserInfo;
import com.example.cloudmusic.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoDao userInfoDao;

    public UserInfo getUserInfo(String tel) {
        return userInfoDao.getUserInfo(tel);
    }

    public  UserInfo getHeaderInfo(String tel){
        return userInfoDao.getHeaderInfo(tel);
    }

    public void updateUserInfo(String tel, String name, String sex,
                               String intro, String birth, String address, String regPhoto){
        userInfoDao.updateUserInfo(tel,name,sex,intro,birth,address,regPhoto);
    }
}
