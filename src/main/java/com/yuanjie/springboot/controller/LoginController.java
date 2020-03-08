package com.yuanjie.springboot.controller;

import com.yuanjie.springboot.properties.StudentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 控制器注解,包含@Controller @ResponseBody 方法返回值应绑定到web响应体
 * 例如：String类型对应text/html，对象可转换成application/json
 */
@RestController
public class LoginController {

    @Autowired
    private StudentProperties studentProperties;

    @GetMapping(value = "/hello")
    public StudentProperties hello() {
        return studentProperties;
    }
}
