package com.example.cloudmusic.service;

import com.example.cloudmusic.entity.LoveList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoveListService {
    LoveList getLoveList(@Param("uuid")String uuid);
    Integer getCount(@Param("uuid")String uuid);
    void addLoveList(LoveList loveList);
}
