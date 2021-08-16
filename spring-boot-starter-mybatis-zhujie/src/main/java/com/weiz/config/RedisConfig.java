package com.weiz.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.lang.reflect.Method;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    /**
     * 采用RedisCacheManager作为缓存管理器
     * 为了处理高可用Redis，可以使用RedisSentinelConfiguration来支持Redis Sentinel。
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheManager redisCacheManager = RedisCacheManager.builder(connectionFactory).build();
        return redisCacheManager;
    }

    /**
     * 自定义生成key的规则
     */
    @Override
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                // 格式化缓存key字符串
                StringBuilder stringBuilder = new StringBuilder();
                // 追加类名
                stringBuilder.append(o.getClass().getName());
                // 追加方法名
                stringBuilder.append(method.getName());
                // 遍历参数并且追加
                for (Object obj :objects) {
                    stringBuilder.append(obj.toString());
                }
                System.out.println("调用Redis缓存Key: " + stringBuilder.toString());
                return stringBuilder.toString();
            }
        };
    }
}