package com.yuanjie.springboot.modules.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * description: 用户实体类
 * @author yuanjie 2020/03/09 15:54t
 */
@Entity // User进行持久化
@Table(name = "test_user")
public class User {
    @Id // 声明主键
    @Column(name = "USERID", nullable = false, length = 20)
    private Long userId;
    @Column(name = "USERNAME", nullable = false, length = 50)
    private String userName;
    private String password;
    private int age;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
