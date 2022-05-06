package com.example.cloudmusic.dao;
import com.example.cloudmusic.entity.LoveList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoveListDao {
    LoveList getLoveList(String uuid);
    Integer getCount(String uuid);
    void addLoveList(LoveList loveList);
}


