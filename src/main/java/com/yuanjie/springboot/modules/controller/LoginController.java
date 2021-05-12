package com.yuanjie.springboot.modules.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSONObject;
import com.yuanjie.springboot.modules.response.HttpResult;
import com.yuanjie.springboot.common.properties.StudentProperties;
import com.yuanjie.springboot.modules.vo.LoginVo;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
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

    // 添加 @Valid 注解，代表此对象使用了参数校验,
    // BindingResult 参数校验的结果会存储在此对象中，可以根据属性判断是否校验通过，校验不通过可以将错误信息打印出来。
    @PostMapping(value = "/login")
    @CircuitBreaker(name = "backendA", fallbackMethod = "fallback")
    @Bulkhead(name = "backendA", type = Bulkhead.Type.SEMAPHORE) // 默认信号量隔离, 线程隔离适用于耗时较长的方法, 线程挂起 & 线程的上下文切换开销较大
    public HttpResult login(@Valid @RequestBody LoginVo lv, BindingResult result) {
        if (result.hasErrors()) {
            throw new RuntimeException("参数校验不通过");
        }
        return new HttpResult("0", "接收反馈信息成功");
    }

    @GetMapping(value = "/hello")
    @SentinelResource(value = "Hello", blockHandler = "blockException")
    public StudentProperties hello() {
        return studentProperties;
    }

    @GetMapping(value = "/test/{number}")
    @SentinelResource(value = "test", blockHandler = "blockException")
    public JSONObject test(@PathVariable(name = "number") Integer number) {
        JSONObject result = new JSONObject();
        if (number % 2 == 0) {
            result.put("success", true);
            return result;
        } else {
            throw new RuntimeException("no even");
        }
    }

    // 熔断器生效时, 走降级策略
    private HttpResult fallback(LoginVo lv, BindingResult result, CallNotPermittedException e) {
        return new HttpResult("-999", "熔断降级策略");
    }

    // 降级策略
    public StudentProperties blockException(BlockException e) {
        return new StudentProperties();
    }

    // 降级策略
    public JSONObject blockException(Integer number, BlockException e) {
        JSONObject result = new JSONObject();
        result.put("message", "降级策略");
        result.put("success", false);
        return result;
    }

}