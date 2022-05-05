package com.example.cloudmusic.dao;

import com.example.cloudmusic.entity.UserDynamic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDynamicDao {
    UserDynamic getUserDynamic(@Param("uuid")String uuid);
}
