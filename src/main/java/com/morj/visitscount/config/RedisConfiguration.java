package com.morj.visitscount.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPooled;

@Configuration
public class RedisConfiguration {
    @Bean
    public JedisPooled jedisPooled(@Value("${spring.redis.host:localhost}") String host,
                                   @Value("${spring.redis.port:6379}") int port) {
        return new JedisPooled(host, port);
    }
}
