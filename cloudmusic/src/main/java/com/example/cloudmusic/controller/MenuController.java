package com.example.cloudmusic.controller;

import com.example.cloudmusic.entity.LoveList;
import com.example.cloudmusic.entity.Menu;
import com.example.cloudmusic.entity.UserInfo;
import com.example.cloudmusic.service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService service;
    @Autowired
    private PassportService passportService;

    @GetMapping("/getMenu")
    @ResponseBody
    public ApiResult getMenu(@Param("uuid") String uuid) {
        List<Menu> menu = service.getMenu(0);
        if (uuid != null && passportService.getPassport(uuid).equals("user")){
            for (Menu e: menu){
                e.setSubMenu( service.getMenu(e.getId()));
            }
        }
        return new ApiResult("200","",menu).success();

    }
}
