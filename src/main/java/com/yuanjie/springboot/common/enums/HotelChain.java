package com.yuanjie.springboot.common.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * 酒店连锁名称
 * @author yuanjie 2020/11/06
 */
public enum HotelChain {

    RU_JIA("如家"),
    JIN_JIANG_ZHI_XING("锦江之星");

    @Getter
    private String chainName;

    HotelChain(String chainName) {
        this.chainName = chainName;
    }

    public static HotelChain transHotelChain(String chainName) {
        HotelChain res = null;
        HotelChain[] enums = HotelChain.values();
        for (HotelChain chain : enums) {
            if (StringUtils.equals(chain.chainName, chainName)) {
                res = chain;
                break;
            }
        }
        return res;
    }

}