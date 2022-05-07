package com.recruit.recruitms.config;

import com.recruit.recruitms.entity.User;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            User admin = new User(
                    "admin",
                    "admin@mail.com",
                    "admin",
                    "admin",
                    LocalDate.of(2000, Month.AUGUST,10),
                    Enum.ObjectState.ACTIVE
            );
            
            repository.save(admin);
        };
    }
}
