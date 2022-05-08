package com.example.cloudmusic.controller;

import com.example.cloudmusic.service.AlbumService;
import com.example.cloudmusic.service.ArtistsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artists")
public class ArtistsController {
    @Autowired
    private ArtistsService service;

    @GetMapping("/getArtists")
    @ResponseBody
    public ApiResult getArtists(@Param("id") String id) {
        return new ApiResult("200","",service.getArtists(id)).success();
    }

    @GetMapping("/addArtists")
    @ResponseBody
    public ApiResult addArtists(@Param("id") String id,
                             @Param("name") String name) {
        service.addArtists(id,name);
        return new ApiResult("200","添加作家成功",null).success();
    }
}
