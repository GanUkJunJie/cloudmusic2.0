package com.example.cloudmusic.dao;

import com.example.cloudmusic.entity.Album;
import com.example.cloudmusic.entity.Lyrics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LyricsDao {
    Lyrics getLyrics(String id);
    void addLyrics(@Param("id")String id, @Param("lyric")String lyric);
}


