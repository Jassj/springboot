package com.yuanjie.springboot.modules.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 酒店资源表
 * @author yuanjie 2020/11/06
 */
@Data
public class HotelResource {

    /**
     * 酒店id
     */
    @JSONField(name = "hotel_id")
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

    /**
     * 景区id
     */
    @JSONField(name = "scenery_id")
    Integer sceneryId;

    // Todo 酒店点评数, 满意度, 起价

    /**
     * 排序id(按照正序展示)
     */
    @JSONField(name = "sort_id")
    Integer sortId;

}
