package com.yuanjie.springboot.modules.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.yuanjie.springboot.common.enums.HotelChain;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 酒店资源表
 * @author yuanjie 2020/11/06
 */
@Data
public class HotelResource {

    /**
     * 酒店id
     */

    Integer hotelId;

    /**
     * 酒店名称
     */
    @JSONField(name = "hotel_name")
    String hotelName;

    /**
     * 酒店图片
     */
    @JSONField(name = "hotel_image_url")
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
    @JSONField(name = "hotel_star")
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

    /**
     * 景区id
     */
    @JSONField(name = "scenery_id")
    Integer sceneryId;

//    /**
//     * 间距(KM)
//     */
//    Double distance;

}
