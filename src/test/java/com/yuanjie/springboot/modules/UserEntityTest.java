package com.yuanjie.springboot.modules;

import com.yuanjie.springboot.modules.entity.User;
import com.yuanjie.springboot.modules.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * description
 * 用户实体类测试
 * @author yuanjie 2020/04/08 19:05
 */
@SpringBootTest
public class UserEntityTest {

    @Autowired
    UserMapper userMapper;

    @Test
    void findUserByAge() {
        List<User> users = userMapper.getListByAge(23);
        for (User user : users) {
            System.out.println("查询到的用户ID：" + user.getUserId() + ", 用户密码：" +
                    user.getPassword() + ", 用户年龄：" + user.getAge() + ", 用户姓名：" + user.getUserName());
        }
    }

    @Test
    void deleteUserById() {
        userMapper.delete(1L);
    }

    @Test
    void createUser() {
        User user = new User();
        user.setUserId(1L);
        user.setPassword("123456");
        user.setUserName("lemon");
        user.setAge(23);
        userMapper.insert(user);
    }

}
