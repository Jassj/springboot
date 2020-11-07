package com.yuanjie.springboot.modules.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface IHotelService {

    List<JSONObject> getHotelById(List<Integer> hotelIds);

    Map<String, String> getHotelDimensions();

    List<JSONObject> score(List<JSONObject> hotelDimensions);

}
