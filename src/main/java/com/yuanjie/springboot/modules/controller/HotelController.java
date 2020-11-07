package com.yuanjie.springboot.modules.controller;

import com.alibaba.fastjson.JSONObject;
import com.yuanjie.springboot.modules.entity.HotelResourceDetail;
import com.yuanjie.springboot.modules.service.IHotelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public List<JSONObject> searchDetail(@RequestBody List<Integer> hotelIds) {
        return hotelService.getHotelById(hotelIds);
    }

    @PostMapping(value = "/dimensions/score")
    @ApiOperation(value = "酒店维度打分", notes = "酒店维度打分对比", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JSONObject> score(@RequestBody List<JSONObject> hotelDimensions) {
        return hotelService.score(hotelDimensions);
    }

    @GetMapping(value = "/dimensions")
    public Map<String, String> getDimensions() {
        return hotelService.getHotelDimensions();
    }

}
