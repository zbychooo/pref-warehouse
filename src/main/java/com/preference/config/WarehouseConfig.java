package com.preference.config;

import com.mysql.jdbc.Driver;
import org.hibernate.dialect.MySQLDialect;
import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan("com.preference")
@EnableJpaRepositories("com.preference.repository")
@EnableTransactionManagement
@EnableWebMvc
public class WarehouseConfig {


    //@Resource
    //private Environment environment;

    @Bean
    public DriverManagerDataSource configureDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Driver.class.getName());
        dataSource.setUrl("jdbc:mysql://localhost:3306/prefdb");
        dataSource.setUsername("root");
        dataSource.setPassword("Pa$$w0rd1");
        return dataSource;
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean configureEntityManager() {

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(configureDataSource());
        factoryBean.setPersistenceProviderClass(HibernatePersistence.class);
        factoryBean.setPackagesToScan("com.preference.model");

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", MySQLDialect.class.getName());
        //  properties.put("hibernate.dialect", MySQL5InnoDBDialect.class.getName());
        properties.put("hibernate.hbm2ddl.auto", "create");
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.format_sql", true);

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