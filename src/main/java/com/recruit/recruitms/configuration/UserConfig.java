package com.recruit.recruitms.configuration;

import com.recruit.recruitms.entity.User;
import com.recruit.recruitms.enumeration.Enum;
import com.recruit.recruitms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

@Configuration
public class UserConfig {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            User admin = new User(
                    "admin",
                    "admin@mail.com",
                    "admin",
                    passwordEncoder.encode("admin123"),
                    Enum.Role.ADMIN,
                    LocalDate.of(2000,Month.AUGUST,10),
                    Enum.Gender.MALE,
                    Enum.ObjectState.ACTIVE
            );
            
            repository.save(admin);
        };
    }
}
