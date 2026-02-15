package ir.online.shop.infrastructure.config;

import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("ir.online.shop.infrastructure.persistence.repository.jpa.spring")
@EntityScan("ir.online.shop.infrastructure.persistence.entity")
public class JpaConfig {
}
