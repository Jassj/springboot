package com.yuanjie.springboot.modules.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 酒店资源详情表
 * @author yuanjie 2020/11/06
 */
@Data
public class HotelResourceDetail {

    /**
     * 酒店id
     */
    @JSONField(name = "hotel_id")
    Integer hotelId;

    /**
     * 房型图片
     */
    @JSONField(name = "room_image_url")
    String roomImageUrl;

    /**
     * 酒店星级
     */
    @JSONField(name = "class_fk")
    Integer star;

    /**
     * 酒店折旧度
     */
    @JSONField(name = "old_new")
    Double oldNew;

    /**
     * 是否连锁
     */
    @JSONField(name = "if_chain")
    Integer ifChain;

    /**
     * 11,12月份销量
     */
    @JSONField(name = "sord_1112")
    Double sord6;

    /**
     * 环境评价
     */
    @JSONField(name = "enr")
    Double enr;

    /**
     * 性价比评价
     */
    @JSONField(name = "prc")
    Double prc;

    /**
     * 服务评价
     */
    @JSONField(name = "svr")
    Double svr;

    /**
     * 隔音评价
     */
    @JSONField(name = "voc")
    Double voc;

    /**
     * 装修评价
     */
    @JSONField(name = "dcr")
    Double dcr;

    /**
     * 位置、交通评价
     */
    @JSONField(name = "trs")
    Double trs;

    /**
     * 风格评价
     */
    @JSONField(name = "sty")
    Double sty;

    /**
     * 设施评价
     */
    @JSONField(name = "sts")
    Double sts;

    /**
     * 消毒情况评价
     */
    @JSONField(name = "dif")
    Double dif;

    /**
     * 其他评价
     */
    @JSONField(name = "oth")
    Double oth;

    /**
     * 各指标打分PK
     */
    Double score;

    /**
     * 各项指标打分
     */
    public void getSummaryScore() {
        score = 1/(1+Math.exp((star + oldNew + ifChain + sord6 + enr + prc + svr + voc + dcr + trs + sty + sts + dif + oth) * (-0.3)));
    }

}
