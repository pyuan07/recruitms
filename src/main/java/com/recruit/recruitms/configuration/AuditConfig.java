package com.recruit.recruitms.configuration;

import com.recruit.recruitms.security.auditable.AuditorAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class AuditConfig {

    @Bean
    public org.springframework.data.domain.AuditorAware<String> auditorAware(){ return new AuditorAware(); }
}
