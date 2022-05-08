package com.example.cloudmusic.service;

import com.example.cloudmusic.entity.Album;
import com.example.cloudmusic.entity.Song;
import org.apache.ibatis.annotations.Param;

public interface SongService {
    Song getSong(String id);
    void addSong(@Param("id")String id, @Param("name")String name, @Param("dt")String dt);
}
