package com.yuanjie.springboot.config;

import com.yuanjie.springboot.common.ESClient;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 数据源、工厂、模板配置类
 * 使用多数据源时: 复制此类配置, 指定数据源、sql工厂和sql模板
 * @author yuanjie 2020/11/06
 */
@Configuration
@MapperScan(basePackages = "com.yuanjie.springboot.modules.mapper")
public class DataSourceConfig {

    @Bean(name = "testDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory
            (@Qualifier("testDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate
            (@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Value("${es.host}")
    private String esHost;

    @Value("${es.cluster}")
    private String esCluster;

    @Bean
    public ESClient esClient() {
        return new ESClient(esHost, esCluster);
    }

}
