package com.zbt.cache.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 参考链接 https://www.cnblogs.com/kancy/p/11162950.html
 *
 * @author zoubaitao
 * date 2022/02/06
 */
@PropertySource(value = {"classpath:application.properties"})
@Configuration
public class ApplicationProperties {
}
