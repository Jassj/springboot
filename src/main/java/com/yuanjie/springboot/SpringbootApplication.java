package com.yuanjie.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.io.support.SpringFactoriesLoader;

/**
 * description:
 * 启动类，spring boot 自动进行相关配置，等价于
 * 1.{@link SpringBootConfiguration @SpringBootConfiguration}: 表示此bean为配置类并加入IOC容器，代替xml配置文件
 * 2.{@link EnableAutoConfiguration @EnableAutoConfiguration}: 此注解通常被用在主应用class上，告诉Spring Boot自动基于当前包添加Bean、对bean的属性进行设置等。
 *    为什么springboot不需要web.xml、servlet.xml文件等配置文件就可以启动项目并且进行IOC容器管控
 *   注：自动配置原则--约定优于配置
 *   a.{@link AutoConfigurationPackage @AutoConfigurationPackage} 包含注解类的包应被注册
 *     {@link AutoConfigurationPackages.Registrar}
 *     针对项目中使用注解的类：注册器根据使用@AutoConfigurationPackage的注解类找到其所属的包及子包并且进行注册并加入IOC容器，与此类不同包的bean将不会自动注册
 *   b.{@link AutoConfigurationImportSelector}
 *     {@link SpringFactoriesLoader#FACTORIES_RESOURCE_LOCATION}
 *     针对三方依赖进行自动装配： 扫描第三方(类似{@link org.springframework.boot.autoconfigure})META-INF/spring.factories文件并加相关依赖引入项目
 *     根据{@link Conditional @Conditional} springboot根据每个类的条件选择什么情况下进行装配，并包括装配的顺序
 * 3.{@link ComponentScan @ComponentScan} 一般与@Configuration一起使用。指定Spring扫描注解的package，如果没有指定包，那么默认会扫描此配置类所在的package
 * @author yuanjie 2020/3/11 0011
 * 4.exclude={DataSourceAutoConfiguration.class} 显示禁止spring boot自动配置数据源
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
