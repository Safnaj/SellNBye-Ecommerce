//package com.paf.configuration;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(entityManagerFactoryRef = "itemEntityManagerFactory",
//		transactionManagerRef = "itemTransactionManager",basePackages = {"com.paf.repository.item","com.paf.repository.seller"})
//public class ItemConfig {
//
//  @Primary
//  @Bean(name = "itemDataSource")
//  @ConfigurationProperties(prefix = "dilshan.datasource")
//  public DataSource dataSource() {
//    return DataSourceBuilder.create().build();
//  }
//
//  @Primary
//  @Bean(name = "itemEntityManagerFactory")
//  public LocalContainerEntityManagerFactoryBean entityManagerFactory(
//      EntityManagerFactoryBuilder builder, @Qualifier("itemDataSource") DataSource dataSource) {
//    return builder.dataSource(dataSource).packages("com.paf.model").persistenceUnit("items")
//        .build();
//  }
//
//  @Primary
//  @Bean(name = "itemTransactionManager")
//  public PlatformTransactionManager transactionManager(
//      @Qualifier("itemEntityManagerFactory") EntityManagerFactory itemEntityManagerFactory) {
//    return new JpaTransactionManager(itemEntityManagerFactory);
//  }
//}
