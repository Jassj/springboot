package com.yuanjie.springboot.modules.mapper;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * scenery mapper
 * @author yuanjie 2020/11/06
 */
@Repository
public interface SceneryMapper {

    @Select("select sr.scenery_id as scenery_id, sr.scenery_name as scenery_name, \n" +
            "sr.image_url as scenery_image_url, hr.hotel_name as hotel_name,\n" +
            "hr.image_url as hotel_image_url, hr.star as hotel_star from \n" +
            "scenery_resource sr \n" +
            "left join\n" +
            "hotel_resource hr \n" +
            "on sr.scenery_id = hr.scenery_id where sr.city_id = #{cityId}")
    List<JSONObject> getSceneryByCityId(@Param("cityId") Long cityId);

}
