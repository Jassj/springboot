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

    /**
     * 景区等级A
     */
    String levelLabel;

    /**
     * 点评数
     */
    @JSONField(name = "comment_count")
    Integer commentCount;

    /**
     * 满意度
     */
    @JSONField(name = "satisfaction")
    String satisfaction;

    /**
     * 景区附近酒店
     */
    List<HotelResource> hotelResourceList = new ArrayList<>();

    /**
     * 根据level拼AAAA
     */
    public void setLevelLabel() {
        StringBuilder levelLabel = new StringBuilder();
        Integer level = this.level;
        for(;level > 0; level--) {
            levelLabel.append("A");
        }
        this.levelLabel = levelLabel.toString();
    }

}
