package com.muxi.api.terminal.configurations;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.muxi.api.terminal.models.entities"})
@EnableJpaRepositories(basePackages = {"com.muxi.api.terminal.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration { }
