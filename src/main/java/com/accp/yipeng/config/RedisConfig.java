package com.accp.yipeng.config;

import java.lang.reflect.Method;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheManager.RedisCacheManagerBuilder;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig extends CachingConfigurerSupport {
	
	@Autowired
	RedisConnectionFactory redisConnectionFactory;
	
	@Bean
	public KeyGenerator keyGenerator() {
		// TODO Auto-generated method stub
		return new KeyGenerator() {
			@Override
			public Object generate(Object target, Method method, Object... params) {
				StringBuffer bf = new StringBuffer();
				bf.append(target.getClass().getName());
				bf.append(method.getName());
				for(Object obj : params) {
					bf.append(obj);
				}
				return bf.toString();
			}
		};
	}
	
	@Bean
	public CacheManager cacheManager() {
		RedisCacheConfiguration cfg = RedisCacheConfiguration.defaultCacheConfig().serializeKeysWith(SerializationPair.fromSerializer(new StringRedisSerializer())).serializeValuesWith(SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer())).entryTtl(Duration.ofHours(1));
		CacheManager cmg = RedisCacheManager
				.builder(redisConnectionFactory)
				.cacheDefaults(cfg)
				.build();
		return cmg;
	}
	

}
