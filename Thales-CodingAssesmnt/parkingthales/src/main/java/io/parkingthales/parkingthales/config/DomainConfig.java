package io.parkingthales.parkingthales.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("io.parkingthales.parkingthales.domain")
@EnableJpaRepositories("io.parkingthales.parkingthales.repos")
@EnableTransactionManagement
public class DomainConfig {
}
