package com.bzhi2.monster.login.component.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther 韩胜军
 * @Date 2020/11/1 12:01
 * @Description 登录页拦截器，登录检查
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    /**
     * @Description 目标方法执行之前
     * @Param [request, response, handler]
     * @return boolean
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从session中获取登录用户名
        Object username = request.getSession().getAttribute("username");
        if(username == null){
            // 未登录，请先登录
            request.setAttribute("msg","请先登录");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }
        // 已登录，放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}