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
@EnableJpaRepositories(entityManagerFactoryRef = "accountEntityManagerFactory",
		transactionManagerRef = "accountTransactionManager",basePackages = {"com.paf.repository.account"})
public class AccountConfig {

	 @Bean(name = "accountDataSource")
	  @ConfigurationProperties(prefix = "bank.datasource")
	  public DataSource dataSource() {
	    return DataSourceBuilder.create().build();
	  }

	  @Bean(name = "accountEntityManagerFactory")
	  public LocalContainerEntityManagerFactoryBean accountEntityManagerFactory(
	      EntityManagerFactoryBuilder builder, @Qualifier("accountDataSource") DataSource dataSource) {
	    return builder.dataSource(dataSource).packages("com.paf.model").persistenceUnit("accounts")
	        .build();
	  }

	  @Bean(name = "accountTransactionManager")
	  public PlatformTransactionManager accountTransactionManager(
	      @Qualifier("accountEntityManagerFactory") EntityManagerFactory accountEntityManagerFactory) {
	    return new JpaTransactionManager(accountEntityManagerFactory);
	  }
}
