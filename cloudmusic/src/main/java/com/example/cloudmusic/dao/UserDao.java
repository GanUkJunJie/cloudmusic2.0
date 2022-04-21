package com.example.cloudmusic.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {

    // 登录
    String login(@Param("tel")String tel);

    //注册
    void register(@Param("tel") String tel, @Param("pwd") String pwd);

    //用户是否存在
    Boolean isExist(@Param("tel") String tel);
}
