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
            "sr.image_url as scenery_image_url, sr.lowest_price as lowest_price, sr.level as level , shm.hotel_id, shm.hotel_name as hotel_name,\n" +
            "shm.sort_id as sort_id,\n" +
            "shm.image_url as hotel_image_url\n" +
            "from \n" +
            "scenery_resource sr \n" +
            "left join\n" +
            "scenery_hotel_mapping shm \n" +
            "on sr.scenery_id = shm.scenery_id" +
            " where sr.city_id = #{cityId}")
    List<JSONObject> getSceneryByCityId(@Param("cityId") Long cityId);

}
