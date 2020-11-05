package com.bzhi2.monster.model.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther 韩胜军
 * @Date 2020/10/30 15:55
 * @Description MVC配置类
 */
@Configuration
public class ModelMvcConfig implements WebMvcConfigurer {

    /**
     * @Description 无业务逻辑跳转页面映射
     * @Param [registry]
     * @return void
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        // 网站入口，访问登录页面
        registry.addViewController("/").setViewName("/login/index");
        // 首页
        registry.addViewController("/welcome").setViewName("/welcome/welcome");

    }

}