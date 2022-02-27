package com.zbt.cache.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;

/**
 * @author zoubaitao
 * date 2022/02/05
 */
@Configuration
@ComponentScan(basePackages = {"com.zbt.cache"})
@EnableCaching
public class BeanConfiguration {

    @Bean
    public ConcurrentMapCache createCache() {
        return new ConcurrentMapCache("message");
    }

    @Bean
    @ConditionalOnBean(value = {ConcurrentMapCache.class})
    public CacheManager createConcurrentCacheManager(Collection<Cache> caches) {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        simpleCacheManager.setCaches(caches);
        return simpleCacheManager;
    }
}
