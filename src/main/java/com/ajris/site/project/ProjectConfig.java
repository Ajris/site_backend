package com.ajris.site.project;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan
public class ProjectConfig {
    @Bean
    public RestTemplate buildRestTemplate(){
        return new RestTemplateBuilder().build();
    }
}
