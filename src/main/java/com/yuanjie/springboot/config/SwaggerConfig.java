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
 * SwaggerConfig
 * @author yuanjie 2020/11/06
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        Predicate<RequestHandler> predicate = input -> {
            Class<?> declaringClass = input.declaringClass();
            return declaringClass.isAnnotationPresent(RestController.class);
        };
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(predicate)
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("同城旅行")
                .description("同城旅行 API 1.0 操作文档")
                .termsOfServiceUrl("https://github.com/Jassj")
                .version("1.0")
                .contact(new Contact("yuanjie", "https://github.com/Jassj", "172161401@qq.com"))
                .build();
    }

}
