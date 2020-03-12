package com.yuanjie.springboot.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * description: 用户实体类
 * @author yuanjie 2020/03/09 15:54t
 */
@Entity // User进行持久化
public class User {
    @Id // 声明主键
    private String userId;
    private String userName;
    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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
}
