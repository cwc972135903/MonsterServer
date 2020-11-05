package com.bzhi2.monster.login.dao.mapper;

import com.bzhi2.monster.login.entity.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Auther 韩胜军
 * @Date 2020/11/3 16:06
 * @Description 注解版UserMapper
 */
@Mapper
public interface AnnotationUserMapper {

    /**
     * @Description 根据id查询用户
     * @Param [id]
     * @return com.bzhi2.monster.login.entity.domain.User
     */
    @Select("select * from user where id=#{id}")
    public User findUserById(Integer id);
}