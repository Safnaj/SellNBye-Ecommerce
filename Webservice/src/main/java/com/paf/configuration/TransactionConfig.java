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
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(entityManagerFactoryRef = "transactionEntityManagerFactory",
//		transactionManagerRef = "transactionTransactionManager",basePackages = {"com.paf.repository.transaction"})
//public class TransactionConfig {
//
//	
//	 @Bean(name = "transactionDataSource")
//	  @ConfigurationProperties(prefix = "bank.datasource")
//	  public DataSource dataSource() {
//	    return DataSourceBuilder.create().build();
//	  }
//
//	  @Bean(name = "transactionEntityManagerFactory")
//	  public LocalContainerEntityManagerFactoryBean transactionEntityManagerFactory(
//	      EntityManagerFactoryBuilder builder, @Qualifier("transactionDataSource") DataSource dataSource) {
//	    return builder.dataSource(dataSource).packages("com.paf.model").persistenceUnit("transactions")
//	        .build();
//	  }
//
//	  @Bean(name = "transactionTransactionManager")
//	  public PlatformTransactionManager transactionTransactionManager(
//	      @Qualifier("transactionEntityManagerFactory") EntityManagerFactory transactionEntityManagerFactory) {
//	    return new JpaTransactionManager(transactionEntityManagerFactory);
//	  }
//}
