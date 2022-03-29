package com.morj.visitscount.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPooled;

@Service
@RequiredArgsConstructor
public class RedisClient {
    private final JedisPooled jedis;

    public long increment(String key) {
        return jedis.incr(key);
    }
}
