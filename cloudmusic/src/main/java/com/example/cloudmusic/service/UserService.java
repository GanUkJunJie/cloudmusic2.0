package com.example.cloudmusic.service;

public interface UserService {
    // 登录
    String login(String tel);
    // 注册
    void register(String uuid,String tel,String password);
    //用户是否存在
    Integer isExist(String tel);
    //获取uuid
    String getUUID(String tel);
}
