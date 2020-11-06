package com.yuanjie.springboot.modules.service;

import com.yuanjie.springboot.modules.entity.SceneryResource;

import java.util.List;

/**
 *
 */
public interface ISceneryService {

    List<SceneryResource> getSceneryByCityId(Long cityId);

}
