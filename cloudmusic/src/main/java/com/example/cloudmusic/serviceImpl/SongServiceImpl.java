package com.example.cloudmusic.serviceImpl;

import com.example.cloudmusic.dao.AlbumDao;
import com.example.cloudmusic.dao.SongDao;
import com.example.cloudmusic.entity.Album;
import com.example.cloudmusic.entity.Song;
import com.example.cloudmusic.service.AlbumService;
import com.example.cloudmusic.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongServiceImpl implements SongService {
    @Autowired
    SongDao songDao;

    @Override
    public Song getSong(String id) {
        return songDao.getSong(id);
    }

    @Override
    public void addSong(String id, String name, String dt) {
        songDao.addSong(id,name,dt);
    }
}
