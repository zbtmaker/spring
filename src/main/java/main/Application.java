package main;

import com.zbt.cache.config.BeanConfiguration;
import com.zbt.cache.config.CacheConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zoubaitao
 * date 2022/02/05
 */
@ComponentScan(basePackageClasses = {BeanConfiguration.class, CacheConfiguration.class})
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
