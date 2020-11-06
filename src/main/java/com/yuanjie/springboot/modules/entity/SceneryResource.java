package com.yuanjie.springboot.modules.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 景区资源表
 * @author yuanjie 2020/11/06
 */
@Data
public class SceneryResource {

    /**
     * 景区id
     */
    @JSONField(name = "scenery_id")
    Integer sceneryId;

    /**
     * 景区名称
     */
    @JSONField(name = "scenery_name")
    String sceneryName;

    /**
     * 景区图片
     */
    @JSONField(name = "scenery_image_url")
    String imageUrl;

//    /**
//     * 景区所属城市id
//     */
//    Long cityId;
//
//    /**
//     * 景区所属城市名称
//     */
//    String cityName;

    /**
     * 最低价格
     */
    @JSONField(name = "lowest_price")
    Integer lowestPrice;

    /**
     * 景区等级
     */
    @JSONField(name = "level")
    Integer level;

    // Todo 景区点评数, 景区满意度,

    /**
     * 景区附近酒店
     */
    List<HotelResource> hotelResourceList = new ArrayList<>();

}
