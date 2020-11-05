package com.bzhi2.monster.login.controller.logincontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Auther 韩胜军
 * @Date 2020/10/29 23:47
 * @Description 登录页Controller
 */
@Controller
public class LoginController {

    /**
     * @Description 验证及登录
     * @Param [username, password, map]
     * @return java.lang.String
     */
    @PostMapping("/login")
    public String signin(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         Map<String,String> map,
                         HttpSession session,Model model){

        // 验证
        if("hansj".equals(username) && "123".equals(password)){
            // 登录用户名存入session
            session.setAttribute("username",username);
            // 密码正确，跳转至首页
            return "redirect:/welcome";
        } else {
            // 密码错误，重新登录
            map.put("msg","账号或密码错误，请重新输入");
            return "/login/index";
        }
    }
}
