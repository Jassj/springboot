package com.yuanjie.springboot.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * description
 * SwaggerConfig
 * @author yuanjie 2020/03/30 17:47
 */
@Configuration
@EnableSwagger2 // 启用 Swagger
public class SwaggerConfig {
    @Bean
    public Docket api() {

        // Swagger会默认把所有Controller中的RequestMapping方法都生成API出来
        Predicate<RequestHandler> predicate = input -> {
            // 被@RestController注解的类才进行生成API
            Class<?> declaringClass = input.declaringClass();
            return declaringClass.isAnnotationPresent(RestController.class);
        };
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(predicate)
                // 这里设置api 生成的范围，有两种方式:
                // 1.上面通过自定义过滤规则
                // 2,通过定义需要生成API的包路径
                //.apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                .build();
    }

    // 配置页面展示的基本信息: 标题、描述、服务条款网址、版本号、联系方法
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("客户管理")
                .description("客户管理中心 API 1.0 操作文档")
                .termsOfServiceUrl("https://github.com/Jassj")
                .version("1.0")
                .contact(new Contact("yuanjie", "https://github.com/Jassj", "172161401@qq.com"))
                .build();
    }

}
