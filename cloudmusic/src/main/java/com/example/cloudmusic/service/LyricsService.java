package com.example.cloudmusic.service;

import com.example.cloudmusic.entity.Album;
import com.example.cloudmusic.entity.Lyrics;
import org.apache.ibatis.annotations.Param;

public interface LyricsService {
    Lyrics getLyrics(String id);
    void addLyrics(String id, String lyric);
}
