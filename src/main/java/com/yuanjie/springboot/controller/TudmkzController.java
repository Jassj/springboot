package com.yuanjie.springboot.controller;

import com.yuanjie.springboot.mapper.TudmkzMapper;
import com.yuanjie.springboot.pojo.Tudmkz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * description
 * 数据库实体类
 * @author yuanjie 2020/03/05 9:39
 */
@RestController
public class TudmkzController {

    private TudmkzMapper tudmkzMapper;

    public TudmkzController(TudmkzMapper tudmkzMapper) {
        this.tudmkzMapper = tudmkzMapper;
    }

    @GetMapping(value = "/tudmkz")
    @ResponseStatus
    public String getTudmkz() {
        List<Tudmkz> list = tudmkzMapper.findAll();
        for(Tudmkz tu : list) {
            System.out.println(tu.getDm()+":"+tu.getFl()+":"+tu.getFydm()+":"+tu.getVal()+":"+tu.getSm());
        }
        return "ok";
    }
}
