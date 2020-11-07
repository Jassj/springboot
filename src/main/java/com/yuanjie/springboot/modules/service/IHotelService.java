package com.yuanjie.springboot.modules.service;

import com.alibaba.fastjson.JSONObject;
import com.yuanjie.springboot.modules.entity.HotelResourceDetail;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface IHotelService {

    List<HotelResourceDetail> getHotelById(List<Integer> hotelIds);

    Map<String, String> getHotelDimensions();

    List<HotelResourceDetail> score(List<JSONObject> hotelDimensions);

}
