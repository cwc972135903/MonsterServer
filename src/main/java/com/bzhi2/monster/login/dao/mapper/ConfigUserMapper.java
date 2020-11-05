package com.bzhi2.monster.login.dao.mapper;

import com.bzhi2.monster.login.entity.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: 韩胜军
 * @Date: 2020/11/3 17:22
 * @Description: xml配置版UserMapper
 */
@Mapper
public interface ConfigUserMapper {

    public User getUserById(Integer id);
}
