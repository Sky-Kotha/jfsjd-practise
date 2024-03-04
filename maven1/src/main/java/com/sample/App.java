package com.sample;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@ComponentScan(basePackages = "com.sample")
public class App {
    public static void main(String[] args) {
        // System.out.println( "Hello World!" );
        ApplicationContext context = new AnnotationConfigApplicationContext("App.class");

        JdbcTemplateDemo jdbcDemo = context.getBean("jdbcTemplateDemo", JdbcTemplateDemo.class);

        System.out.println(jdbcDemo.getCountofEmployees());
    }

    @Bean 
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/Verizon-training");
        dataSource.setUsername("postgre");
        dataSource.setPassword("Post0414@");

        return dataSource;
    }
    
    @Bean
    public JdbcTemplateDemo jdbcTemplateDemo(DataSource dataSource) {
        return new JdbcTemplateDemo(dataSource);
    }
}
