package com.yuanjie.springboot.test;

import com.yuanjie.springboot.common.ESClient;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.elasticsearch.action.get.GetRequestBuilder;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.unit.TimeValue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class EsDemo {

    @Autowired
    ESClient esClient;

    @Test
    void esTest() throws IOException {

        // 通过传输客户端与ES交互
        TransportClient client = esClient.getClient();

        // 通过id查询唯一记录
        GetRequestBuilder grb = client.prepareGet("megacorp", "employee", "1");

        GetResponse gr = grb.get();

        System.out.println(gr.getSourceAsString());
    }

}
