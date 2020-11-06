package com.yuanjie.springboot.common.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;

import org.apache.commons.io.IOUtils;

import com.alibaba.fastjson.JSON;

import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.Decoder;

public class FastJsonDecoder implements Decoder {

    public FastJsonDecoder() {
    }

    @Override
    public Object decode(Response response, Type type) throws IOException, FeignException {
        if (response.body() == null) {
            return null;
        }
        if (response.status() == 404) {
            return Util.emptyValueOf(type);
        }
        try {
            Reader reader = response.body().asReader();
            if (!reader.markSupported()) {
                reader = new BufferedReader(reader, 1);
            }
            reader.mark(1);
            if (reader.read() == -1) {
                return null;
            }
            reader.reset();
            return JSON.parseObject(IOUtils.toString(reader), type);
        } catch (Exception e) {
            throw e;
        }
    }
}
