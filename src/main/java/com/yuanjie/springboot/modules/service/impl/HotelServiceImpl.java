package com.yuanjie.springboot.modules.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yuanjie.springboot.modules.entity.HotelResourceDetail;
import com.yuanjie.springboot.modules.mapper.HotelMapper;
import com.yuanjie.springboot.modules.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements IHotelService {

    private static final Map<String, String> DIMENSIONS = new HashMap<String, String>() {
        {
            put("class_fk", "酒店星级");
            put("old_new", "酒店新旧");
            put("if_chain", "是否连锁");
            put("sord_1112", "11,12月份销量");
            put("enr", "环境评价");
            put("prc", "性价比评价");
            put("svr", "服务评价");
            put("voc", "隔音评价");
            put("dcr", "装修评价");
            put("trs", "位置、交通评价");
            put("sty", "风格评价");
            put("sts", "设施评价");
            put("dif", "消毒情况评价");
            put("oth", "其他评价");
        }
    };

    @Autowired
    HotelMapper hotelMapper;

    @Override
    public List<HotelResourceDetail> getHotelById(List<Integer> hotelIds) {
        List<JSONObject> list = hotelMapper.getHotelById(hotelIds);
        return list.stream().map(json -> {
            HotelResourceDetail detail = json.toJavaObject(HotelResourceDetail.class);
            detail.getSummaryScore();
            return detail;
        }).collect(Collectors.toList());
    }

    @Override
    public Map<String, String> getHotelDimensions() {
        return DIMENSIONS;
    }

    @Override
    public List<HotelResourceDetail> score(List<JSONObject> hotelDimensions) {
//        hotelDimensions
        // 两个酒店指标数据进行打分并输出结果
        return null;
    }

}
