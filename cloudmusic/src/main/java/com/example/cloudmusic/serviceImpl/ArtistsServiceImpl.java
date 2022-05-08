package com.example.cloudmusic.serviceImpl;

import com.example.cloudmusic.dao.AlbumDao;
import com.example.cloudmusic.dao.ArtistsDao;
import com.example.cloudmusic.entity.Album;
import com.example.cloudmusic.entity.Artists;
import com.example.cloudmusic.service.AlbumService;
import com.example.cloudmusic.service.ArtistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistsServiceImpl implements ArtistsService {
    @Autowired
    ArtistsDao artistsDao;

    @Override
    public Artists getArtists(String id){
        return artistsDao.getArtists(id);
    }

    @Override
    public void addArtists(String id, String name){
        artistsDao.addArtists(id,name);
    }
}
