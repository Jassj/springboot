package com.yuanjie.springboot.common.client;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

import feign.Param;
import feign.RequestLine;
import lombok.Data;

public interface TideEsApi {

	/**
	 * 查询es
	 */
	@RequestLine("POST /index/{index}/template/{queryTemplate}/latest/search")
	QueryResponse queryEs(JSONObject param, @Param("index") String index,
						  @Param("queryTemplate") String queryTemplate);

	/**
	 * 带routingkey查询e
	 */
	@RequestLine("POST /index/{index}/template/{queryTemplate}/latest/search?routing={routingkey}")
	QueryResponse queryEs(JSONObject param, @Param("index") String index,
						  @Param("queryTemplate") String queryTemplate, @Param("routingkey") String routingKey);

	/**
	 * 注意：插入或者更新es，JSONObject中必须带索引配置的routing字段
	 */
	@RequestLine("POST /index/{index}/type/info/bulk")
	WriteResponse insertEs(List<JSONObject> param, @Param("index") String index);



	@RequestLine("DELETE /index/{index}/type/info/{Id}?routing={routingKey}")
	WriteResponse deleteById(@Param("index") String index, @Param("Id") String id, @Param("routingKey") String routingKey);

	@Data
	class QueryResponse {
		Integer code;
		String message;
		ResponseResult result;
	}

	@Data
	class ResponseResult {
		private int took;
		private int count;
		private List<JSONObject> list;
	}

	@Data
	class WriteResponse implements Serializable {
		Integer code;
		String message;
		String result;
	}

}
