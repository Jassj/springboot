package com.yuanjie.springboot.modules.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;

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
     * 酒店id
     */
    @JSONField(name = "hotel_name")
    Integer hotelName;

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
     * 各项指标打分:
     */
    public void getSummaryScore() {
        // 未选择打分为null的指标值置为默认值1
        Integer star = Objects.nonNull(this.star) ? this.star : 1;
        Double oldNew = Objects.nonNull(this.oldNew) ? this.oldNew : 1.0;
        Integer ifChain = Objects.nonNull(this.ifChain) ? this.ifChain : 1;
        Double sord6 = Objects.nonNull(this.sord6) ? this.sord6 : 1.0;
        Double enr = Objects.nonNull(this.enr) ? this.enr : 1.0;
        Double prc = Objects.nonNull(this.prc) ? this.prc : 1.0;
        Double svr = Objects.nonNull(this.svr) ? this.svr : 1.0;
        Double voc = Objects.nonNull(this.voc) ? this.voc : 1.0;
        Double dcr = Objects.nonNull(this.dcr) ? this.dcr : 1.0;
        Double trs = Objects.nonNull(this.trs) ? this.trs : 1.0;
        Double sty = Objects.nonNull(this.sty) ? this.sty : 1.0;
        Double sts = Objects.nonNull(this.sts) ? this.sts : 1.0;
        Double dif = Objects.nonNull(this.dif) ? this.dif : 1.0;
        Double oth = Objects.nonNull(this.oth) ? this.oth : 1.0;
        Double score = 1/(1+Math.exp((star + oldNew + ifChain + sord6 + enr + prc + svr + voc + dcr + trs + sty + sts + dif + oth) * (-0.3)));
        BigDecimal bg = new BigDecimal(score);
        this.score = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
