package com.example.cloudmusic.controller;

import com.example.cloudmusic.service.UserDynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userDynamic")
public class UserDynamicController {
    @Autowired
    private UserDynamicService service;

    @GetMapping("/getUserDynamic")
    @ResponseBody
    public ApiResult getUserBase(@RequestParam("uuid") String uuid) {
        return new ApiResult("200","",service.getUserDynamic(uuid)).success();
    }
}
