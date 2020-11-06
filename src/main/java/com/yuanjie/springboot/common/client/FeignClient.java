package com.yuanjie.springboot.common.client;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import feign.Feign;
import feign.Request;
import feign.Retryer;
import lombok.extern.slf4j.Slf4j;


/**
 * 远程调用客户端
 * @author yuanjie 2020/11/06
 */
@Slf4j
@Component
public class FeignClient {

	public static final String ES_UPDATE_URL = "http://dc.es.dss.17usoft.com";
	public static final String ES_QUERY_URL = "http://dcopen.es.dss.17usoft.com";
	public static final String USER_ID_TRANSFORM_URL = "http://mkcloud.17usoft.com";
	public static final String OPEN_API_URL = "http://bds.17usoft.com/tcodpapi";


	public <T> T getCommonService(Class<T> t, String baseUrl) {
		return getCommonService(t, baseUrl, "");
	}
	
	/**
	 * 默认请求超时策略和重试策略
 	 */
	public <T> T getCommonService(Class<T> t, String baseUrl, String token) {
		return getCommonService(t, baseUrl, token, new Request.Options(1000, 2000), new Retryer.Default(100, 500, 1));
	}

	/**
	 * 自定义请求超时策略和重试策略
	 */
	public <T> T getCommonService(Class<T> t, String baseUrl, String token, Request.Options options, Retryer.Default retryer) {
		Feign.Builder builder = Feign.builder()
				.decoder(new FastJsonDecoder())
				.encoder(new FastJsonEncoder())
				.options(options)
				.retryer(retryer);

		if(StringUtils.isNotBlank(token)) {
			builder = builder.requestInterceptor(interceptor -> {
				interceptor.header("Content-Type", "application/json");
				interceptor.header("Authentication", token);
				interceptor.header("token", token);
			});
		}
		return builder.target(t, baseUrl);
	}

	public static FeignClient getInstance() {
		return FeignServiceHolder.FEIGN_SERVICE;
	}

	/**
	 * 静态内部类，单例
	 */
	private static class FeignServiceHolder {
		private static final FeignClient FEIGN_SERVICE = new FeignClient();
	}

}
