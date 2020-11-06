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

    /**
     * 最低价格
     */
    @JSONField(name = "hotel_lowest_price")
    Integer lowestPrice;

    /**
     * 点评数
     */
    @JSONField(name = "hotel_comment_count")
    Integer commentCount;

    /**
     * 满意度
     */
    @JSONField(name = "hotel_satisfaction")
    String satisfaction;

    /**
     * 排序id(按照正序展示)
     */
    @JSONField(name = "sort_id")
    Integer sortId;

}
