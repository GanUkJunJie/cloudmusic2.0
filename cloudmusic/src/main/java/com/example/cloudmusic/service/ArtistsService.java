package com.example.cloudmusic.service;

import com.example.cloudmusic.entity.Album;
import com.example.cloudmusic.entity.Artists;
import org.apache.ibatis.annotations.Param;

public interface ArtistsService {
    Artists getArtists(String id);
    void addArtists(String id, String name);
}
