package com.bzhi2.monster.login.controller;

import com.bzhi2.monster.login.dao.mapper.AnnotationUserMapper;
import com.bzhi2.monster.login.dao.mapper.ConfigUserMapper;
import com.bzhi2.monster.login.entity.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther 韩胜军
 * @Date 2020/11/3 16:24
 * @Description
 */
@Controller
public class UserController {

    @Autowired
    AnnotationUserMapper annotationUserMapper;

    @Autowired
    ConfigUserMapper configUserMapper;

    @ResponseBody
    @GetMapping("/getuser/{id}")
    public User getUser(@PathVariable("id") Integer id){
        User userById = annotationUserMapper.findUserById(id);
        System.out.println(userById.getBirthday());
        System.out.println(userById.getUsername());
        return userById;
    }

    @ResponseBody
    @GetMapping("/getuserbyid/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        User userById = configUserMapper.getUserById(id);
        System.out.println(userById);
        return userById;
    }


}