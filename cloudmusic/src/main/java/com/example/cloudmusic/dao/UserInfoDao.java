package com.example.cloudmusic.dao;


import com.example.cloudmusic.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserInfoDao {

    UserInfo getUserInfo(String tel);

    UserInfo getHeaderInfo(String tel);


    void updateUserInfo(@Param("tel") String tel,@Param("name")  String name,@Param("sex") String sex,
                        @Param("intro") String intro,@Param("birth") String birth,
                        @Param("address") String address,@Param("regPhoto") String regPhoto);
}
