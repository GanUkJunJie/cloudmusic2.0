package com.example.cloudmusic.dao;

import com.example.cloudmusic.entity.Lyrics;
import com.example.cloudmusic.entity.Song;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SongDao {
    Song getSong(String id);
    void addSong(@Param("id")String id, @Param("name")String name, @Param("dt")String dt);
}


