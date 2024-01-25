package dev.be.async.config;

import dev.be.async.feign.logger.FeignCustomLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public FeignCustomLogger feignLogger() {
        return new FeignCustomLogger();
    }
}
