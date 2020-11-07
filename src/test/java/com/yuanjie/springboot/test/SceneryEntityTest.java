package com.yuanjie.springboot.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yuanjie.springboot.modules.entity.HotelResource;
import com.yuanjie.springboot.modules.entity.SceneryResource;
import com.yuanjie.springboot.modules.mapper.SceneryMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * description
 * 用户实体类测试
 * @author yuanjie 2020/04/08 19:05
 */
@SpringBootTest
public class SceneryEntityTest {

    @Autowired
    SceneryMapper mapper;

    @Test
    void test() {
        System.out.println(mapper.getSceneryByCityId(264L));
        List<JSONObject> list = mapper.getSceneryByCityId(264L);
        List<SceneryResource> sceneryResources = list.stream().map(json -> json.toJavaObject(SceneryResource.class)).distinct()
                .collect(Collectors.toList());
        Map<Integer, SceneryResource> sceneryResourceMap = sceneryResources.stream().collect(Collectors.toMap(SceneryResource::getSceneryId, Function.identity()));
        List<HotelResource> hotelResources = list.stream().map(json -> json.toJavaObject(HotelResource.class)).distinct()
                .collect(Collectors.toList());
        System.out.println(sceneryResources);
        System.out.println(hotelResources);
        hotelResources.forEach(hotelResource -> {
            if(sceneryResourceMap.containsKey(hotelResource.getSceneryId())) {
                SceneryResource resource = sceneryResourceMap.get(hotelResource.getSceneryId());
                resource.getHotelResourceList().add(hotelResource);
            }
        });
        System.out.println(JSON.toJSONString(sceneryResources));
    }

}
