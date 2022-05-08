package com.example.cloudmusic.dao;

import com.example.cloudmusic.entity.Album;
import com.example.cloudmusic.entity.Artists;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ArtistsDao {
    Artists getArtists(String id);
    void addArtists(@Param("id")String id, @Param("name")String name);
}


