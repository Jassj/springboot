package com.yuanjie.springboot.modules.entity;

import lombok.Data;

/**
 * 景区资源表
 * @author yuanjie 2020/11/06
 */
@Data
public class SceneryResource {

    /**
     * 景区id
     */
    Integer sceneryId;

    /**
     * 景区名称
     */
    String sceneryName;

    /**
     * 景区图片
     */
    String imageUrl;

    /**
     * 景区所属城市id
     */
    Integer cityId;

    /**
     * 景区所属城市名称
     */
    String cityName;

    /**
     * 最低价格
     */
    Double lowestPrice;

}
