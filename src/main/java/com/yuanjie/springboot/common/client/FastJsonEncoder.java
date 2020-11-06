package com.yuanjie.springboot.common.client;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;

import com.alibaba.fastjson.JSON;

import feign.Request;
import feign.RequestTemplate;
import feign.Util;
import feign.codec.EncodeException;
import feign.codec.Encoder;

public class FastJsonEncoder implements Encoder {
    public FastJsonEncoder() {
    }

    @Override
    public void encode(Object o, Type type, RequestTemplate requestTemplate) throws EncodeException {
        Request.Body body = null;
        if (o == null) {
            o = "";
        }
        try {
            body = Request.Body.encoded(JSON.toJSONString(o).getBytes("utf-8"), Util.UTF_8);
        } catch (UnsupportedEncodingException e) {
        }
        requestTemplate.body(body);
    }
}
