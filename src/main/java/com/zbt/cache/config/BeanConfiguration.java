package com.zbt.cache.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zoubaitao
 * date 2022/02/05
 */
@Configuration
@ComponentScan(basePackages = {"com.zbt.cache"})
@EnableCaching
public class BeanConfiguration {
}
