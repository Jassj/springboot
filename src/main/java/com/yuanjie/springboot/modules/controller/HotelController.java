package com.yuanjie.springboot.modules.controller;

import com.yuanjie.springboot.modules.entity.HotelResource;
import com.yuanjie.springboot.modules.service.IHotelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yuanjie 2020/11/06
 */
@RestController
@RequestMapping("/hotel")
@Api(value = "酒店资源", description = "酒店资源")
public class HotelController {

    @Autowired
    private IHotelService hotelService;

    @PostMapping(value = "/search/detail")
    @ApiOperation(value = "酒店资源详情", notes = "酒店资源详情", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HotelResource> searchDetail(@RequestBody List<Integer> hotelIds) {
        return hotelService.getHotelById(hotelIds);
    }

}
