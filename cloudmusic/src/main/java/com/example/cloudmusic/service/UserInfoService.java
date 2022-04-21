package com.example.cloudmusic.service;


import com.example.cloudmusic.entity.UserInfo;

public interface UserInfoService {
    UserInfo getUserInfo(String tel);

    UserInfo getHeaderInfo(String tel);

    void updateUserInfo(String tel,String name,String sex,
            String intro,String birth, String address,String regPhoto);
}
