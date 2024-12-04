package com.bagus.gen_24_java_springboot_pos.service.redis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RedisService {
    private final StringRedisTemplate redisTemplate;

    public void save(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
        log.info("Redis: Data saved, key={}, value={}", key, value);
    }

    public String get(String key) {
        String value = redisTemplate.opsForValue().get(key);
        if (value != null) {
            log.info("Redis: Data retrieved, key={}, value={}", key, value);
        } else {
            log.warn("Get null on key={}", key);
        }

        return value;
    }
}
