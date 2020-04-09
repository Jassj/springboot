package com.yuanjie.springboot.modules.mapper;

import com.yuanjie.springboot.modules.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * description
 * 用户映射类
 * @author yuanjie 2020/04/08 20:21
 */
@Repository
public interface UserMapper {
    @Delete("delete from test_user where userId = #{id}")
    void delete(Long id);

    @Select("select * from test_user where age = #{age}")
    List<User> getListByAge(@Param("age") int userAge);

    @Select("select * from test_user where userName = #{userName} and age = #{age}")
    List<User> getListByNameAndAge(User user);

    @Insert("insert into test_user(userId, userName, password, age) values (#{userId}, #{userName}, #{password}, #{age}) ")
    void insert(User user);

    @Update("update test_user set password = #{password} where userId = #{userId}")
    void updatePasswordById(User user);
}
