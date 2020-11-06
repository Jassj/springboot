package com.yuanjie.springboot.modules.service;

import com.yuanjie.springboot.modules.entity.HotelResource;

import java.util.List;

/**
 *
 */
public interface IHotelService {

    List<HotelResource> getHotelById(List<Integer> hotelIds);

}
