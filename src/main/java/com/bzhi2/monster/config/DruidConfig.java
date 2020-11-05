package com.bzhi2.monster.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther 韩胜军
 * @Date 2020/11/3 13:55
 * @Description druid配置类
 */
@Configuration
public class DruidConfig {

    /**
     * @Description 创建druid数据源
     * @Param []
     * @return javax.sql.DataSource
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

    /**
     * @Description 配置druid管理后台的servlet
     * @Param
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<Servlet> servletServletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
        Map<String,String> initParams = new HashMap<>();
        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","admin");
        initParams.put("allow","");// 默认允许所有访问
        initParams.put("deny","192.168.15.21");// 拦截192.168.15.21的访问

        servletServletRegistrationBean.setInitParameters(initParams);
        return servletServletRegistrationBean;
    }

    /**
     * @Description 配置web监控的filter
     * @Param
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new WebStatFilter());
        Map<String, String> initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.css,/druid/*");// 排除项

        filterFilterRegistrationBean.setInitParameters(initParams);
        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/"));
        return filterFilterRegistrationBean;
    }











}