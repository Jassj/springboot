package com.yuanjie.springboot.modules.controller;

import com.yuanjie.springboot.modules.response.HttpResult;
import com.yuanjie.springboot.common.properties.StudentProperties;
import com.yuanjie.springboot.modules.vo.LoginVo;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 *
 * 控制器注解,包含@Controller @ResponseBody 方法返回值应绑定到web响应体
 * 例如：String类型对应text/html，对象可转换成application/json
 */
@RestController
public class LoginController {

    @Resource
    private StudentProperties studentProperties;

    @GetMapping(value = "/hello")
    public StudentProperties hello() {
        return studentProperties;
    }

    // 添加 @Valid 注解，代表此对象使用了参数校验,
    // BindingResult 参数校验的结果会存储在此对象中，可以根据属性判断是否校验通过，校验不通过可以将错误信息打印出来。
    @PostMapping(value = "/login")
    public HttpResult login(@Valid LoginVo lv, BindingResult result) {
        if(result.hasErrors()) {
            return new HttpResult("-1", result);
        }
        return new HttpResult("0","接收反馈信息成功");
    }
}
