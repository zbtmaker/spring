package com.zbt.cache.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.zbt.cache.utils.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author zoubaitao
 * date 2022/02/27
 */
@Configuration
@EnableCaching
public class CacheConfiguration {

    @Autowired
    private Environment environment;

    public CacheManager caffeineCacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        Map<String, CaffeineCache> cacheMap = new HashMap<>();
        AbstractEnvironment abstractEnvironment = (AbstractEnvironment) environment;
        for (PropertySource<?> source : abstractEnvironment.getPropertySources()) {
            Object o = source.getSource();
            if (o instanceof Map) {
                for (Map.Entry<String, String> entry : (((Map<String, String>) o).entrySet())) {
                    String key = entry.getKey();
                    if (key.startsWith("app.cache")) {
                        String cacheName = key.substring(10);
                        CacheConfig cacheConfig = JacksonUtil.parseObject(entry.getValue(), CacheConfig.class);
                        Assert.notNull(cacheConfig);
                        Caffeine<Object, Object> caffeine = Caffeine.newBuilder();

                        caffeine.expireAfterAccess(cacheConfig.expireAfterAccess, TimeUnit.SECONDS);
                        caffeine.expireAfterWrite(cacheConfig.expireAfterWriter, TimeUnit.SECONDS);
                        CaffeineCache caffeineCache = new CaffeineCache(cacheName, caffeine.build());
                        cacheMap.put(cacheName, caffeineCache);
                    }
                }
            }
        }
        cacheManager.setCaches(cacheMap.values());
        return cacheManager;
    }

    private static class CacheConfig {

        private Integer maximumSize;

        private Integer expireAfterAccess;

        private Integer expireAfterWriter;
    }
}

