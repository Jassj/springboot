package com.yuanjie.springboot.modules.service.impl;

import com.yuanjie.springboot.modules.entity.HotelResource;
import com.yuanjie.springboot.modules.mapper.HotelMapper;
import com.yuanjie.springboot.modules.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements IHotelService {

    @Autowired
    HotelMapper hotelMapper;

    @Override
    public List<HotelResource> getHotelBySceneryId(List<String> sceneryIds) {
        return hotelMapper.getHotelBySceneryId(sceneryIds);
    }

}
