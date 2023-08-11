package com.sambit.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 10/05/2023 - 9:20 AM
 */
@Configuration
public class LoggerConfig {
    @Bean
    public Logger getLogger() {
        return LoggerFactory.getLogger(LoggerConfig.class);
    }
}
