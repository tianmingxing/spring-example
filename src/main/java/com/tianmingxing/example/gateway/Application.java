package com.tianmingxing.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * Describe the purpose of the current class.
 *
 * @author tianmingxing
 * @version 1.0.0
 * @date 2018/11/23 20:41
 * @since 1.0.0
 */
@SpringBootApplication
public class Application {

    @Bean
    KeyResolver userKeyResolver() {
        return exchange -> {
            String user = exchange.getRequest().getQueryParams().getFirst("user");
            return Mono.just(Objects.requireNonNull(user));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
