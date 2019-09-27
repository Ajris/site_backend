package com.ajris.site;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.concurrent.Executor;

@EnableDiscoveryClient
@EnableAsync
@SpringBootApplication
public class SiteApplication {
    public static void main(String[] args) {
        SpringApplication.run(SiteApplication.class, args);
    }

    @Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setQueueCapacity(1000);
        executor.setThreadNamePrefix("AjrisExecutor- ");
        executor.initialize();
        return executor;
    }
}
