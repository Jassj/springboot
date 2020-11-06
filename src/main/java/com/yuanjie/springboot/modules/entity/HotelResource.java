package com.yuanjie.springboot.modules.entity;

import com.yuanjie.springboot.common.enums.HotelChain;

import java.time.LocalDateTime;

/**
 * 酒店资源表
 * @author yuanjie 2020/11/06
 */
public class HotelResource {

    /**
     * 酒店id
     */
    Integer hotelId;

    /**
     * 酒店名称
     */
    String hotelName;

    /**
     * 酒店图片
     */
    String imageUrl;

//    /**
//     * 酒店所属城市id
//     */
//    Integer cityId;
//
//    /**
//     * 酒店所属城市名称
//     */
//    String cityName;

    /**
     * 酒店星级
     */
    Integer star;

    /**
     * 开店时间
     */
    LocalDateTime openTime;

    /**
     * 最近一次装修时间
     */
    LocalDateTime fixTime;

    /**
     * 酒店连锁
     */
    HotelChain hotelChain;

}
