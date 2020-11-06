package com.yuanjie.springboot.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yuanjie.springboot.common.ESClient;
import com.yuanjie.springboot.common.client.FeignClient;
import com.yuanjie.springboot.common.client.TideEsApi;
import org.elasticsearch.action.get.GetRequestBuilder;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class EsDemo {

    @Autowired
    ESClient esClient;

    @Test
    void esTest() {

        // 通过传输客户端与ES交互
        TransportClient client = esClient.getClient();

        // 通过id查询唯一记录
        GetRequestBuilder grb = client.prepareGet("megacorp", "employee", "1");

        GetResponse gr = grb.get();

        System.out.println(gr.getSourceAsString());
    }


    public static void main(String[] args) {
//        TideEsApi ES_API = FeignClient.getInstance().getCommonService(TideEsApi.class, FeignClient.ES_QUERY_URL, "3e300222-7dd6-45db-a1d5-6c26ca626591");
//        JSONObject request = new JSONObject();
//        request.put("unionid", "ohmdTt-Oll3-mLzSS16eZtGO7_aU");
//        String FEATURE_OFFLINE_INDEX = "salm-memberflightfeature-offline-*";
//        String FEATURE_OFFLINE_TEMPLATE = "query_by_unionid";
//        TideEsApi.QueryResponse response = ES_API.queryEs(request, FEATURE_OFFLINE_INDEX, FEATURE_OFFLINE_TEMPLATE, "ohmdTt-Oll3-mLzSS16eZtGO7_aU");
//        System.out.println(JSON.toJSONString(response));


    }

}
