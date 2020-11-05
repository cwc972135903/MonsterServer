package com.bzhi2.monster.login.config;

import com.bzhi2.monster.login.component.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther 韩胜军
 * @Date 2020/10/30 15:55
 * @Description MVC配置类
 */
@Configuration
public class LoginMvcConfig implements WebMvcConfigurer {

    /**
     * @Description 视图映射
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

    /**
     * @Description 注册拦截器
     * @Param [registry]
     * @return void
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 登录拦截器，进行登录检查
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/","/login");
    }
}