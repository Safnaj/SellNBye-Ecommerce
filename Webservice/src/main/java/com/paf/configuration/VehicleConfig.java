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
//public class VehicleConfig {
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(entityManagerFactoryRef = "customerEntityManagerFactory",
//		transactionManagerRef = "vehicleTransactionManager",basePackages = {"com.paf.repository.vehicle"})
//public class deliveryConfig {
//	@Bean(name = "vehicleDataSource")
//	  @ConfigurationProperties(prefix = "shasikala.datasource")
//	  public DataSource dataSource() {
//	    return DataSourceBuilder.create().build();
//	  }
//
//	  @Bean(name = "vehicleEntityManagerFactory")
//	  public LocalContainerEntityManagerFactoryBean deliveryEntityManagerFactory(
//	      EntityManagerFactoryBuilder builder, @Qualifier("vehicleDataSource") DataSource dataSource) {
//	    return builder.dataSource(dataSource).packages("com.paf.model").persistenceUnit("vehicle")
//	        .build();
//	  }
//
//	  @Bean(name = "vehicleTransactionManager")
//	  public PlatformTransactionManager vehicleTransactionManager(
//	      @Qualifier("vehicleEntityManagerFactory") EntityManagerFactory vehicleEntityManagerFactory) {
//	    return new JpaTransactionManager(vehicleEntityManagerFactory);
//	  }
//
//}
//}