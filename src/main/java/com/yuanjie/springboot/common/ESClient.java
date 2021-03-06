package com.yuanjie.springboot.common;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ESClient {

    private String cluster;

    private String host;

    private TransportClient client;

    public RestClient getRestClient() {
        return restClient;
    }

    public void setRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    private RestClient restClient;

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public TransportClient getClient() {
        return client;
    }

    public void setClient(TransportClient client) {
        this.client = client;
    }

    public ESClient(String host, String cluster) {
        this.cluster = cluster;
        this.host = host;
        Settings settings = Settings.builder().put("cluster.name", cluster).build();
        String[] hostArray = StringUtils.split(host, ";");
        HttpHost[] hostArr = new HttpHost[hostArray.length];
        for (int i = 0; i < hostArray.length; i++) {
            String[] info = StringUtils.split(hostArray[i], ":");
            hostArr[i] = new HttpHost(info[0].trim(), Integer.parseInt(info[1].trim()) - 100, "http");
        }
        try {
            client = new PreBuiltTransportClient(settings).addTransportAddresses(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        restClient = RestClient.builder(hostArr).build();
    }

    /**
     * 关闭
     */
    public void close() {
        if (client != null) {
            client.close();
        }
    }
}
