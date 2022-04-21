package com.example.cloudmusic.dao;

import com.example.cloudmusic.entity.UserBase;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserBaseDao {
    UserBase getUserBase(String tel);
}
