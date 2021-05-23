package com.yuanjie.springboot.config.sentinel;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 请求来源token控制
 * @author jie2.yuan
 * @version 1.0.0
 * @since 2021/05/23
 */
@Component
public class TokenRequestOriginParser implements RequestOriginParser {

    private static final String TOKEN = "Token";

    @Override
    public String parseOrigin(HttpServletRequest request) {
        return request.getHeader(TOKEN);
    }

}
