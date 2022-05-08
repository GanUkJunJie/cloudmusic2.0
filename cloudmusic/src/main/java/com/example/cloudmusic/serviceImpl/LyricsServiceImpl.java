package com.example.cloudmusic.serviceImpl;

import com.example.cloudmusic.dao.AlbumDao;
import com.example.cloudmusic.dao.LyricsDao;
import com.example.cloudmusic.entity.Album;
import com.example.cloudmusic.entity.Lyrics;
import com.example.cloudmusic.service.AlbumService;
import com.example.cloudmusic.service.LyricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LyricsServiceImpl implements LyricsService {
    @Autowired
    LyricsDao lyricsDao;
    @Override
    public Lyrics getLyrics(String id) {
        return lyricsDao.getLyrics(id);
    }

    @Override
    public void addLyrics(String id, String lyric) {
        lyricsDao.addLyrics(id,lyric);
    }
}
