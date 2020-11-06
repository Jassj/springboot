package com.yuanjie.springboot.modules.controller;

import com.yuanjie.springboot.modules.entity.SceneryResource;
import com.yuanjie.springboot.modules.service.ISceneryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yuanjie 2020/11/06
 */
@RestController
@RequestMapping("/scenery")
@Api(value = "景区资源", description = "推送景区以及相关资源")
public class SceneryController {

    @Autowired
    private ISceneryService sceneryService;

    @GetMapping(value = "/search/{cityId}")
    @ApiOperation(value = "景区资源", notes = "查询景区及周边酒店资源", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SceneryResource> search(@PathVariable("cityId") @ApiParam(value = "城市id") Long cityId) {
        return sceneryService.getSceneryByCityId(cityId);
    }

}
