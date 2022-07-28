package com.store.db.config;

import com.alibaba.druid.pool.DruidDataSource;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.logging.log4j2.Log4j2Impl;
import org.apache.ibatis.session.LocalCacheScope;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.Properties;


/**
 * 自定义数据源配置
 * @author jiawei
 * 2018年7月23日下午10:02:24
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.store.db.mapper")
public class DataSourceConfiguration {

	@Autowired
	@Qualifier("myProperties")
    private Properties properties;

    @SuppressWarnings("static-access")
	@Bean(destroyMethod="close")
    public DataSource getDataSource() throws PropertyVetoException {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(properties.getProperty("driver"));
		dataSource.setUrl(properties.getProperty("url"));

        dataSource.setUsername(properties.getProperty("username"));
        dataSource.setPassword(properties.getProperty("password"));
        
        dataSource.setInitialSize(Integer.parseInt(
        		properties.getProperty("initialPoolSize")));
        dataSource.setMinIdle(Integer.parseInt(
        		properties.getProperty("minPoolSize")));
        dataSource.setMaxActive(Integer.parseInt(properties.getProperty("maxActive")));
        dataSource.setMaxWait(Integer.parseInt(properties.getProperty("maxWait")));
        dataSource.setTestWhileIdle(Boolean.parseBoolean(properties.getProperty("testWhileIdle")));
        dataSource.setTimeBetweenConnectErrorMillis(Long.parseLong(
				properties.getProperty("timeBetweenEvictionRunsMillis")));
		dataSource.setMinEvictableIdleTimeMillis(Long.parseLong(
				properties.getProperty("minEvictableIdleTimeMillis")));
		dataSource.setTestOnBorrow(Boolean.parseBoolean(properties.getProperty("testOnBorrow")));
		dataSource.setTestOnReturn(Boolean.parseBoolean(properties.getProperty("testOnReturn")));
		dataSource.setPoolPreparedStatements(Boolean.parseBoolean(properties.getProperty("poolPreparedStatements")));
		dataSource.setMaxPoolPreparedStatementPerConnectionSize(Integer.parseInt(
				properties.getProperty("maxPoolPreparedStatementPerConnectionSize")));
        return dataSource;
    }

	/**
	 * 事务管理器
	 * @return
	 * @throws PropertyVetoException
	 */
    @Bean
    public DataSourceTransactionManager transactionManager() throws PropertyVetoException {
    	DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(getDataSource());
    	return dataSourceTransactionManager;
    }

	/**
	 * Mybatis Plus 的 sessionFactoryBean
	 * @return: MybatisSqlSessionFactoryBean （Mybatis plus的 SqlSessionFactory）
	 * @author: fengjiawei
	 * @date: 2022/7/19 00:20
	**/
    @Bean
    public MybatisSqlSessionFactoryBean getSqlSessionFactory() throws PropertyVetoException, IOException {
		MybatisSqlSessionFactoryBean sessionFactoryBean = new MybatisSqlSessionFactoryBean();
    	sessionFactoryBean.setDataSource(getDataSource());
    	sessionFactoryBean.setFailFast(true);
    	sessionFactoryBean.setTypeAliasesPackage("com.store.db.entry.*"); //类型别名可为 Java 类型设置一个缩写名字。 它仅用于 XML 配置，意在降低冗余的全限定类名书写
    	PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    	sessionFactoryBean.setMapperLocations(resolver.getResources("mapper/*.xml")); //设置xml文件位置
		sessionFactoryBean.setConfiguration(mybatisConfiguration());
		return sessionFactoryBean;
    }

	/**
	 * mybatis 的原生Configuration
	 * @return
	 */
	@Bean
	public MybatisConfiguration mybatisConfiguration() {
		MybatisConfiguration mybatisConfiguration = new MybatisConfiguration();
		mybatisConfiguration.setLogImpl(Log4j2Impl.class); //log4j输出SQL日志
		mybatisConfiguration.setLocalCacheScope(LocalCacheScope.STATEMENT); //SESSION  级别缓存，同一个 session 相同查询语句不会再次查询数据库。msql8已经不支持
		return mybatisConfiguration;
	}


	/**
	 * 配置内部分页拦截器
	 * 用来指定方言，当然也可以省略
	 * @return: PaginationInnerInterceptor
	 * @author: fengjiawei
	 * @date: 2022/7/19 11:55
	**/
	@Bean
	public PaginationInnerInterceptor paginationInnerInterceptor() {
		// 对于单一数据库类型来说,都建议配置该值,避免每次分页都去抓取数据库类型
		return new PaginationInnerInterceptor(DbType.MYSQL);
	}
}
