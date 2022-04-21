package com.example.cloudmusic.service;


public interface UserService {
    // 登录
    String login(String tel);
    // 注册
    void register(String tel,String pwd);

    Boolean isExist(String tel);


}
