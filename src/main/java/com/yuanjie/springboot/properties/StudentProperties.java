package com.yuanjie.springboot.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * description: 自定义配置信息类
 * 使用注释处理器生成自己的元数据使用spring-boot-configuration-processor jar从带有@ConfigurationProperties
 * 注释的项目中轻松生成自己的配置元数据文件,该jar包含一个Java注释处理器，在项目被编译时会被调用
 * @author yuanjie 2020/03/04 19:27
 */
@Component
@ConfigurationProperties(prefix = "student")
public class StudentProperties {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
