package com.example.cloudmusic.controller;

import com.example.cloudmusic.service.AlbumService;
import com.example.cloudmusic.service.LyricsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lyrics")
public class LyricsController {
    @Autowired
    private LyricsService service;

    @GetMapping("/getLyrics")
    @ResponseBody
    public ApiResult getLyrics(@Param("id") String id) {
        return new ApiResult("200","",service.getLyrics(id)).success();
    }

    @GetMapping("/addLyrics")
    @ResponseBody
    public ApiResult addLyrics(@Param("id") String id,
                             @Param("lyric") String lyric) {
        service.addLyrics(id,lyric);
        return new ApiResult("200","添加歌词成功",null).success();
    }
}
