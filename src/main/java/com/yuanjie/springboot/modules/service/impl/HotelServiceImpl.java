package com.yuanjie.springboot.modules.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yuanjie.springboot.modules.entity.HotelResource;
import com.yuanjie.springboot.modules.mapper.HotelMapper;
import com.yuanjie.springboot.modules.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements IHotelService {

    @Autowired
    HotelMapper hotelMapper;

    @Override
    public List<HotelResource> getHotelById(List<Integer> hotelIds) {
        List<JSONObject> list = hotelMapper.getHotelById(hotelIds);
        // Todo 酒店资源详情: 床型图, 预测得分, 酒店详情
        return list.stream().map(json -> json.toJavaObject(HotelResource.class)).collect(Collectors.toList());
    }

}
