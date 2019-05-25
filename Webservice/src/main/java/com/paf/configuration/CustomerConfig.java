package com.paf.configuration;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "customerEntityManagerFactory",
		transactionManagerRef = "customerTransactionManager",basePackages = {"com.paf.repository.customer"})
public class CustomerConfig {
	 @Bean(name = "customerDataSource")
	  @ConfigurationProperties(prefix = "shaneli.datasource")
	  public DataSource dataSource() {
	    return DataSourceBuilder.create().build();
	  }

	  @Bean(name = "customerEntityManagerFactory")
	  public LocalContainerEntityManagerFactoryBean customerEntityManagerFactory(
	      EntityManagerFactoryBuilder builder, @Qualifier("customerDataSource") DataSource dataSource) {
	    return builder.dataSource(dataSource).packages("com.paf.model").persistenceUnit("customers")
	        .build();
	  }

	  @Bean(name = "customerTransactionManager")
	  public PlatformTransactionManager customerTransactionManager(
	      @Qualifier("customerEntityManagerFactory") EntityManagerFactory customerEntityManagerFactory) {
	    return new JpaTransactionManager(customerEntityManagerFactory);
	  }

}
