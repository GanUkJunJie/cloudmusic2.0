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
    void register(@Param("uuid") String uuid, @Param("tel") String tel, @Param("password") String password);

    //用户是否存在
    Integer isExist(@Param("tel") String tel);

    //获取用户uuid
    String getUUID(@Param("tel") String tel);
}
