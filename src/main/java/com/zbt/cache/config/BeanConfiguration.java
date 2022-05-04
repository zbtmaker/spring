package com.zbt.cache.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author zoubaitao
 * date 2022/02/05
 */
@Configuration
@ComponentScan(basePackages = {"com.zbt.cache"})
@PropertySource(value = {"classpath:application.properties"})
public class BeanConfiguration {
}
