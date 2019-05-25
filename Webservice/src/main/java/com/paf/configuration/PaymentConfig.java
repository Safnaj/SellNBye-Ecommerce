package com.paf.configuration;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "paymentEntityManagerFactory",
    transactionManagerRef = "paymentTransactionManager", basePackages = {"com.paf.repository.payment"})
public class PaymentConfig {

  @Primary
  @Bean(name = "paymentDataSource")
  @ConfigurationProperties(prefix = "udara.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }

  @Primary
  @Bean(name = "paymentEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean paymentEntityManagerFactory(
      EntityManagerFactoryBuilder builder, @Qualifier("paymentDataSource") DataSource dataSource) {
    return builder.dataSource(dataSource).packages("com.paf.model").persistenceUnit("payments")
        .build();
  }

  @Primary
  @Bean(name = "paymentTransactionManager")
  public PlatformTransactionManager paymentTransactionManager(
      @Qualifier("paymentEntityManagerFactory") EntityManagerFactory paymentEntityManagerFactory) {
    return new JpaTransactionManager(paymentEntityManagerFactory);
  }

}
