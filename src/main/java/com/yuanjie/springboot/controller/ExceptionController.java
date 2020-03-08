package com.yuanjie.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author yuanjie 2020/03/06 16:23
 */
@RestController
public class ExceptionController {

    @GetMapping(value = "/zeroException")
    public int zeroException() {
        return 100 / 0;
    }
}
