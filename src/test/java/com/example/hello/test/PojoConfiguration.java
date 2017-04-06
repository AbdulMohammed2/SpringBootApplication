package com.example.hello.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@EnableConfigurationProperties
@Component
public class PojoConfiguration {
    @Value("${my.pojo.name}")
    public String name;

  @Bean
  @ConfigurationProperties(prefix="iassconfig")
    public Pojo pojo() {
        return new Pojo(name);
    }
 }