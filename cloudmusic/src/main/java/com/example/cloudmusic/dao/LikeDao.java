package com.example.cloudmusic.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LikeDao {
    Integer getLike(@Param("uuid")String uuid, @Param("songId")String songId);
    List<String> getLikeList(String uuid);
    void addLike(@Param("uuid")String uuid, @Param("songId")String songId);
    void delLike(@Param("uuid")String uuid, @Param("songId")String songId);
}


