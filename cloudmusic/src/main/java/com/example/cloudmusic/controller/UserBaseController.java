package com.example.cloudmusic.controller;

import com.example.cloudmusic.service.UserBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userBase")
public class UserBaseController {
    @Autowired
    private UserBaseService service;

    @GetMapping("/getUserBase")
    @ResponseBody
    public ApiResult getUserBase(@RequestParam("uuid") String uuid) {
        return new ApiResult("200","",service.getUserBase(uuid)).success();
    }
}
