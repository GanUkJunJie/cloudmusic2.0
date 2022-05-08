package com.example.cloudmusic.service;

import com.example.cloudmusic.entity.Album;

public interface AlbumService {
    Album getAlbum(String id);
    void addAlbum(String id, String name, String picUrl);
}
