package com.spring.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.spring.model.*;

@Configuration
@EnableWebMvc
@ComponentScan("com.spring")
@EnableTransactionManagement
public class ApplicationContextConfig extends WebMvcConfigurerAdapter{
    
	
	@Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
		System.out.println("-- viewResolver");
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("-- entrando en addResourceHandlers");
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/assets/");
		registry.addResourceHandler("/images/**").addResourceLocations("/assets/images/");
//		registry.addResourceHandler("/fonts/**").addResourceLocations("/assets/fonts/");
//		registry.addResourceHandler("/js/**").addResourceLocations("/assets/js/");
	}
        
    @Bean(name = "dataSource")
    public DataSource getDataSource() {
    	BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
  
    	//--- CONEXION DE MARIO PARA LA BASE DE DATOS ---//
    	dataSource.setUrl("jdbc:mysql://192.168.200.2:3306/agenda");
    	dataSource.setUsername("mariolus");
    	dataSource.setPassword("yayolus");
    	
    	//--- CONEXION DE PABLO PARA LA BASE DE DATOS ---//
    	//dataSource.setUrl("jdbc:mysql://192.168.200.2:3306/agenda");
    	//dataSource.setUsername("pablo");
    	//dataSource.setPassword("pablo");
    	
//    	//--- CONEXION DE ZAINEB PARA LA BASE DE DATOS ---//
//    	dataSource.setUrl("jdbc:mysql://192.168.200.2:3306/agenda");
//    	dataSource.setUsername("zaineb");
//    	dataSource.setPassword("zaineb");
    	
    	//--- CONEXION DE GABRIEL PARA LA BASE DE DATOS ---//
    	//dataSource.setUrl("jdbc:mysql://localhost:3306/agenda");
    	//dataSource.setUsername("root");
    	//dataSource.setPassword("1111");
   
    	return dataSource;
    }
       
    private Properties getHibernateProperties() {
    	Properties properties = new Properties();
    	properties.put("hibernate.show_sql", "true");
    	properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    	return properties;
    }
    
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    	sessionBuilder.addProperties(getHibernateProperties());
//    	sessionBuilder.addAnnotatedClasses(Direccion.class);
    	sessionBuilder.addAnnotatedClasses(Persona.class);
//    	sessionBuilder.addAnnotatedClasses(Telefono.class);
    	return sessionBuilder.buildSessionFactory();
    }
    
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);

		return transactionManager;
	}
    
}
