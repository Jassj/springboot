package com.yuanjie.springboot.modules.controller;

import com.yuanjie.springboot.modules.entity.HotelResource;
import com.yuanjie.springboot.modules.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yuanjie 2020/11/06
 */
@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private IHotelService hotelService;

    @PostMapping(value = "/search")
    public List<HotelResource> search(@RequestBody List<Integer> hotelIds) {
        return hotelService.getHotelById(hotelIds);
    }

}
