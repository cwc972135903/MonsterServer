package com.bzhi2.monster.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

    /**
     * @Auther 韩胜军
     * @Date 2020/11/3 16:59
     * @Description MyBatis配置类
     */
    @org.springframework.context.annotation.Configuration
    public class MyBatisConfig {

    /**
     * @Description 自定义配置
     * @Param
     * @return
     */
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer() {
            @Override
            public void customize(Configuration configuration) {
                // 开启驼峰命名
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}