package com.example.cloudmusic.service;


import com.example.cloudmusic.entity.UserInfo;

public interface UserInfoService {
    UserInfo getUserInfo(String uuid);

    void updateUserInfo(String uuid,String name,String sex,
            String intro,Integer birthYear,Integer birthMonth,
            Integer birthDay, String address,String avatar);
}
