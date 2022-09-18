package com.zbt.cache.service.dubbo.producer;

import com.zbt.cache.service.dubbo.producer.impl.ProviderServiceImpl;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * @author zoubaitao
 * date 2022/09/12
 */
public class ProviderMain {

    public static void main(String[] args) throws Exception {
        ProviderService providerService = new ProviderServiceImpl();

        ServiceConfig<ProviderService> service = new ServiceConfig<>();
        service.setInterface(ProviderService.class);
        service.setRef(providerService);

        ApplicationConfig applicationConfig = new ApplicationConfig("dubbo-demo-api-provider");
        applicationConfig.setQosEnable(false);
        applicationConfig.setCompiler("jdk");

        Map<String, String> m = new HashMap<>(1);
        m.put("proxy", "jdk");
        applicationConfig.setParameters(m);

        service.setApplication(applicationConfig);
        service.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        service.export();

        System.out.println("dubbo service started");
        new CountDownLatch(1).await();
    }
}
