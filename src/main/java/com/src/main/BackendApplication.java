package com.src.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

/**
 * Created by mj on 22/5/16.
 */

@ComponentScan("com.src")
@SpringBootApplication
@EnableJpaRepositories
@EntityScan
public class BackendApplication {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication app = new SpringApplication(BackendApplication.class);

//        SpringApplication.run(QuizApplication.class, args);
        app.setShowBanner(true);
        app.run(args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
