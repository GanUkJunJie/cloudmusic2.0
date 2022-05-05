package com.example.cloudmusic.dao;


import com.example.cloudmusic.entity.UserBase;
import com.example.cloudmusic.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserInfoDao {

    UserInfo getUserInfo(String uuid);

    void updateUserInfo(@Param("uuid") String uuid,@Param("name")  String name,@Param("sex") String sex,
                        @Param("intro") String intro,@Param("birthYear") Integer birthYear,
                        @Param("birthMonth") Integer birthMonth,@Param("birthDay") Integer birthDay,
                        @Param("address") String address,@Param("avatar") String regPhoto);

    UserBase getUserBase(String uuid);
}
