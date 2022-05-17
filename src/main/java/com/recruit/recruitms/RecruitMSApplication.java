package com.recruit.recruitms;

import com.recruit.recruitms.configuration.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Import(SwaggerConfig.class)
public class RecruitMSApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecruitMSApplication.class, args);
    }

}
