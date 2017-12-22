package com.khsrd.springboot.configuration;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.khsrd.springboot.repository")
public class DbConfiguration {

}
