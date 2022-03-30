package com.morj.visitscount.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPooled;

@Service
@RequiredArgsConstructor
public class RedisClient {
    private final JedisPooled jedis;

    public void increment(String key) {
        jedis.incr(key);
    }

    public void set(String key, String value) {
        jedis.set(key, value);
    }

    public String get(String key) {
        return jedis.get(key);
    }

    public String getSet(String key, String value) {
        return jedis.getSet(key, value);
    }
}
