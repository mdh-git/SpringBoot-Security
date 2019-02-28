package com.mdh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: madonghao
 * @Date: 2019/2/26 15:52
 */
@Controller
public class MenuController {

    private final String PREFIX = "lol/";

    /**
     * 欢迎页面
     * @return
     */
    @GetMapping(value = "/")
    public String welcome(){
        return "welcome";
    }

    /**
     * 自定义登陆
     * @return
     */
    @GetMapping("/userlogin")
    public String userlogin(){
        return PREFIX + "login";
    }

    /**
     * 默认的登陆
     * @return
     */
    @GetMapping("/login")
    public String login(){
        return PREFIX + "login";
    }

    @GetMapping("/bronze")
    public String bronze(){
        return PREFIX + "bronze";
    }

    @GetMapping("/silver")
    public String silver(){
        return PREFIX + "silver";
    }

    @GetMapping("/gold")
    public String gold(){
        return PREFIX + "gold";
    }

    @GetMapping("/platinum")
    public String platinum(){
        return PREFIX + "platinum";
    }

    @GetMapping("/diamond")
    public String diamond(){
        return PREFIX + "diamond";
    }

    @GetMapping("/master")
    public String master(){
        return PREFIX + "master";
    }

    @GetMapping("/challenger")
    public String challenger(){
        return PREFIX + "challenger";
    }
}
