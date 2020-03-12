package com.yuanjie.springboot.vo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

// JSR 是一个规范文档，指定了一整套 API，通过标注给对象属性添加约束。Hibernate Validator 就是 JSR 规范的具体实现，
// Hibernate Validator 提供了 JSR 规范中所有内置约束注解的实现，以及一些附加的约束注解，除此之外用户还可以自定义约束注解。
public class LoginVo {

    // username用户名校验
    @NotEmpty(message = "username不能为空")
    private String username;

    // age年龄校验
    @Max(value = 60, message = "超过60岁不建议访问")
    @Min(value = 18, message = "未满18岁禁止访问")
    private int age;

    //password密码校验
    @NotEmpty(message = "password不能为空")
    @Length(min = 6, message = "密码不得小于6位")
    @Length(max = 30, message = "密码不建议大于30位")
    private String password;

    // token验证码暂不校验
    private String token;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LoginVo{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
