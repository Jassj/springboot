package com.yuanjie.springboot.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * description
 * 数据源、工厂、模板配置类
 * 使用多数据源时: 复制此类配置, 指定数据源、sql工厂和sql模板
 * @author yuanjie 2020/04/08 20:16
 */
@Configuration
@MapperScan(basePackages = "com.yuanjie.springboot.modules.mapper"/*, sqlSessionFactoryRef = "sqlSessionTemplate"*/)
public class DataSourceConfig {

//    @Bean(name = "testDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource testDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "sqlSessionFactory")
//    public SqlSessionFactory testSqlSessionFactory
//            (@Qualifier("testDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        return bean.getObject();
//    }
//
//    @Bean(name = "sqlSessionTemplate")
//    public SqlSessionTemplate testSqlSessionTemplate
//            (@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
}
