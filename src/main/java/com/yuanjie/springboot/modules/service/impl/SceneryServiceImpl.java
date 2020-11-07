package com.yuanjie.springboot.modules.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yuanjie.springboot.modules.entity.HotelResource;
import com.yuanjie.springboot.modules.entity.SceneryResource;
import com.yuanjie.springboot.modules.mapper.SceneryMapper;
import com.yuanjie.springboot.modules.service.ISceneryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class SceneryServiceImpl implements ISceneryService {

    @Autowired
    SceneryMapper sceneryMapper;

    @Override
    public List<SceneryResource> getSceneryByCityId(Long cityId) {
        List<JSONObject> list = sceneryMapper.getSceneryByCityId(cityId);
        // 处理数据成单景区多酒店格式
        List<SceneryResource> sceneryResources = list.stream().map(json -> json.toJavaObject(SceneryResource.class)).distinct()
                .collect(Collectors.toList());
        Map<Integer, SceneryResource> sceneryResourceMap = sceneryResources.stream().collect(Collectors.toMap(SceneryResource::getSceneryId, Function.identity()));
        List<HotelResource> hotelResources = list.stream().map(json -> json.toJavaObject(HotelResource.class)).distinct()
                .collect(Collectors.toList());
        hotelResources.forEach(hotelResource -> {
            if(sceneryResourceMap.containsKey(hotelResource.getSceneryId())) {
                SceneryResource resource = sceneryResourceMap.get(hotelResource.getSceneryId());
                resource.getHotelResourceList().add(hotelResource);
            }
        });
        // 根据sort_id排序并保留前10条数据
        sceneryResources = sceneryResources.stream().peek(sceneryResource -> {
            sceneryResource.setLevelLabel();
            List<HotelResource> newHotelResources =  sceneryResource.getHotelResourceList().stream().sorted(Comparator.comparing(HotelResource::getSortId))
            .limit(10).collect(Collectors.toList());
            sceneryResource.setHotelResourceList(newHotelResources);}).collect(Collectors.toList());
        return sceneryResources;
    }

}
