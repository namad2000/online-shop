package ir.shop.online.core.infrastructure.config;

import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
@EnableJpaRepositories("ir.shop.online.core.infrastructure.persistence.repository.jpa.spring")
@EntityScan("ir.shop.online.core.infrastructure.persistence.entity")
public class JpaConfig {
}
