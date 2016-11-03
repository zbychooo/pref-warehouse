package com.preference.config;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan("com.preference")
@EnableJpaRepositories("com.preference.repository")
@EnableTransactionManagement
@EnableWebMvc
@PropertySource("classpath:config.properties")
public class WarehouseConfig {

    @Resource
    private Environment env;

    @Bean
    public DriverManagerDataSource configureDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("com.pref.database.driverClass"));
        dataSource.setUrl(env.getProperty("com.pref.database.url"));
        dataSource.setUsername(env.getProperty("com.pref.database.username"));
        dataSource.setPassword(env.getProperty("com.pref.database.password"));

        //DatabasePopulatorUtils.execute(configureDatabasePopulator(), dataSource);

        return dataSource;
    }

    public DatabasePopulator configureDatabasePopulator() {
        final ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.setContinueOnError(true);
        databasePopulator.addScript(new ClassPathResource("00testdata.sql"));
        return databasePopulator;
    }


    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean configureEntityManager() {

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(configureDataSource());
        factoryBean.setPersistenceProviderClass(HibernatePersistence.class);
        factoryBean.setPackagesToScan("com.preference.model");

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", env.getProperty("com.pref.hibernate.dialect"));
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("com.pref.hibernate.hbm2ddl.auto"));
        properties.put("hibernate.show_sql", env.getProperty("com.pref.hibernate.show_sql"));
        properties.put("hibernate.format_sql", env.getProperty("com.pref.hibernate.format_sql"));

        factoryBean.setJpaPropertyMap(properties);

        return factoryBean;
    }

    @Bean(name = "transactionManager")
    public JpaTransactionManager configureTransationManager() {

        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(configureEntityManager().getObject());
        return transactionManager;
    }
}