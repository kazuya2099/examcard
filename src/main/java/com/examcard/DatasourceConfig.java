package com.examcard;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan("com.example.spring_boot.dao")
public class DatasourceConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/examcard?autoReconnect=true&useSSL=false");
		driverManagerDataSource.setUsername("examcard");
		driverManagerDataSource.setPassword("password");
		return driverManagerDataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}

	@Bean
	public SqlSessionFactoryBean sessionFactory() {
		Resource[] mapperLocations = {
				new ClassPathResource("/sql/common/userDao.xml"),
				new ClassPathResource("/sql/common/informationDao.xml"),
				new ClassPathResource("/sql/common/sequenceDao.xml"),
				new ClassPathResource("/sql/application/customerApplicationDao.xml"),
				new ClassPathResource("/sql/top/userCardDao.xml"),
				new ClassPathResource("/sql/top/pointDao.xml"),
		};

		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource());
		bean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		bean.setMapperLocations(mapperLocations);
		return bean;
	}

	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactoryBean sessionFactory) {
		SqlSessionTemplate bean= null;
		try {
			bean = new SqlSessionTemplate(sessionFactory.getObject());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
}
