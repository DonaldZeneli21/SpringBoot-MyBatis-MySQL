package com.myproject.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class MybatisConfig {
	
	public final String MAPPER_LOCATIONS_PATH = "classpath:mapper/*.xml";
	public final String TYPE_ALIASES_PACKAGE = "com.myproject.mapper";       
    //public final String TYPE_HANDLERS_PACKAGE = "it.itsvil.cartellanr.hendler"; //per gli errori  
	public final String CONFIG_FILE_NAME = "mybatis-config.xml";       
	    
    //when you have multiple data sources, you can use:
    @Autowired
    private Environment env;
    
    @Primary
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        return dataSource;
    }
    
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(getDataSource());

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(MAPPER_LOCATIONS_PATH));        
        sqlSessionFactoryBean.setTypeAliasesPackage(TYPE_ALIASES_PACKAGE);
        //sqlSessionFactoryBean.setTypeHandlersPackage(TYPE_HANDLERS_PACKAGE);       
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(CONFIG_FILE_NAME));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
    	 DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(getDataSource());
         transactionManager.setGlobalRollbackOnParticipationFailure(false);
         return transactionManager;
    }
    
}