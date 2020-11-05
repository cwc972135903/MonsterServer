package com.bzhi2.monster.login.controller.welcomecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther 韩胜军
 * @Date 2020/10/30 10:44
 * @Description B支2首页Controller
 */
@Controller
public class WelcomeController {

    /**
     * @Description 访问首页
     * @Param
     * @return
     */
    @RequestMapping("/welcome/welcome.html")
    public String welocme(){
        return "/welcome/welcome";
    }
}