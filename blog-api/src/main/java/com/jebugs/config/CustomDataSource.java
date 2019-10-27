package com.jebugs.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Author: haozx1
 * @Description: MasterDataSource
 * @CreateDate: 2019/6/26 17:21
 */
@Configuration
@MapperScan(basePackages = {"com.jebugs.repository"}, sqlSessionFactoryRef = "sqlSessionFactoryMaster")
public class CustomDataSource {

    @Primary
    @Bean(name = "dataSourceMaster")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSourceMaster() {
        //指定使用DruidDataSource
        return DataSourceBuilder.create()
                .type(DruidDataSource.class)
                .build();
    }

    @Bean(name = "sqlSessionFactoryMaster")
    public SqlSessionFactory sqlSessionFactoryMaster(@Qualifier("dataSourceMaster") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }


    @Bean(name = "transactionManagerMaster")
    public DataSourceTransactionManager transactionManagerMaster(@Qualifier("dataSourceMaster") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sqlSessionTemplateMaster")
    public SqlSessionTemplate sqlSessionTemplateMaster(@Qualifier("sqlSessionFactoryMaster") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
