package com.preference.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.activation.DataSource;
import javax.annotation.Resource;

@Configuration
//@EnableWebMvc
@ComponentScan("com.preference.model")
@EnableJpaRepositories("com.preference.repository")
public class WarehouseConfig {


    @Resource
    private Environment environment;

    @Bean
    public DataSource configureDataSource() {
        return null;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean configureEntityManager() {
        return null;
    }

    @Bean
    public JpaTransactionManager configureTransationManager() {
        return null;
    }

}
