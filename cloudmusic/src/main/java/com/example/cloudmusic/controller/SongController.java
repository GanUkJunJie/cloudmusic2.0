package com.example.cloudmusic.controller;

import com.example.cloudmusic.service.LyricsService;
import com.example.cloudmusic.service.SongService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/song")
public class SongController {
    @Autowired
    private SongService service;

    @GetMapping("/getSong")
    @ResponseBody
    public ApiResult getSong(@Param("id") String id) {
        return new ApiResult("200","",service.getSong(id)).success();
    }

    @GetMapping("/addSong")
    @ResponseBody
    public ApiResult addSong(@Param("id") String id,
                             @Param("name") String name, @Param("dt") String dt) {
        service.addSong(id,name,dt);
        return new ApiResult("200","添加歌词成功",null).success();
    }
}
