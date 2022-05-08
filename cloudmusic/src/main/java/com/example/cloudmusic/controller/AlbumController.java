package com.example.cloudmusic.controller;
import com.example.cloudmusic.service.AlbumService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService service;

    @GetMapping("/getAlbum")
    @ResponseBody
    public ApiResult getAlbum(@Param("id") String id) {
        return new ApiResult("200","",service.getAlbum(id)).success();
    }

    @GetMapping("/addAlbum")
    @ResponseBody
    public ApiResult addAlbum(@Param("id") String id,
                             @Param("name") String name, @Param("picUrl") String picUrl) {
        service.addAlbum(id,name,picUrl);
        return new ApiResult("200","添加专辑成功",null).success();
    }
}
