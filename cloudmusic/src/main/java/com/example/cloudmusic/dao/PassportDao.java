package com.example.cloudmusic.dao;

import com.example.cloudmusic.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PassportDao {
    String getPassport(String uuid);
}


