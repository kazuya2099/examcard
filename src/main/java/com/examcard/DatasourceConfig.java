package com.examcard;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.examcard.constant.ErrorCode;
import com.examcard.exception.SystemException;

@Configuration
@EnableTransactionManagement
@MapperScan("com.examcard.mapper")
public class DatasourceConfig {

	@Bean
	DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/examcard?useSSL=false");
		driverManagerDataSource.setUsername("examcard");
		driverManagerDataSource.setPassword("password");
		return driverManagerDataSource;
	}

	@Bean
	PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}

	@Bean
	SqlSessionFactoryBean sessionFactory() throws IOException {
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource());
		bean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		bean.setMapperLocations(resolver.getResources("classpath:com/examcard/**/*.xml"));
		return bean;
	}

	@Bean
	SqlSessionTemplate sqlSession() {
		SqlSessionTemplate bean = null;
		try {
			bean = new SqlSessionTemplate(sessionFactory().getObject());
		} catch (Exception e) {
			throw new SystemException(ErrorCode.E500000, e);
		}
		return bean;
	}
}
