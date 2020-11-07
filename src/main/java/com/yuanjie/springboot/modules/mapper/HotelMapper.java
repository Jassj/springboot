package com.yuanjie.springboot.modules.mapper;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * hotel mapper
 * @author yuanjie 2020/11/06
 */
@Repository
public interface HotelMapper {

    @Select({"<script>" +
            "select * from hotel_resource_detail where hotel_id in " +
            "<foreach collection=\"hotelIds\" index = \"index\" item = \"hotel_id\" open= \"(\" separator=\",\" close=\")\"> " +
            "#{hotel_id} </foreach>" +
            "</script>"})
    List<JSONObject> getHotelById(@Param("hotelIds") List<Integer> hotelIds);

}
