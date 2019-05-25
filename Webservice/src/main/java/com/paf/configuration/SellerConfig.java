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
@EnableJpaRepositories(entityManagerFactoryRef = "sellerEntityManagerFactory",
		transactionManagerRef = "sellerTransactionManager",basePackages = {"com.paf.repository.seller"})

public class SellerConfig {
	 @Bean(name = "sellerDataSource")
	  @ConfigurationProperties(prefix = "dilshan.datasource")
	  public DataSource dataSource() {
	    return DataSourceBuilder.create().build();
	  }

	  @Bean(name = "sellerEntityManagerFactory")
	  public LocalContainerEntityManagerFactoryBean sellerEntityManagerFactory(
	      EntityManagerFactoryBuilder builder, @Qualifier("sellerDataSource") DataSource dataSource) {
	    return builder.dataSource(dataSource).packages("com.paf.model").persistenceUnit("sellers")
	        .build();
	  }

	  @Bean(name = "sellerTransactionManager")
	  public PlatformTransactionManager sellerTransactionManager(
	      @Qualifier("sellerEntityManagerFactory") EntityManagerFactory sellerEntityManagerFactory) {
	    return new JpaTransactionManager(sellerEntityManagerFactory);
	  }
}
