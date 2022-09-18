package com.zbt.cache.service.dubbo.consumer;

import com.zbt.cache.service.dubbo.dto.DemoRequestDTO;
import com.zbtmaker.dubbo.bo.GenericRpcReq;
import com.zbtmaker.dubbo.service.GenericRpcService;
import com.zbtmaker.dubbo.service.impl.GenericRpcServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import zbtmaker.boot.common.util.JacksonUtils;

/**
 * @author zoubaitao
 * date 2022/09/18
 */
@Slf4j
public class ConsumerMain {
    public static void main(String[] args) {
        ApplicationConfig applicationConfig = new ApplicationConfig("dubbo-demo-api-consumer");
        RegistryConfig registryConfig = new RegistryConfig("zookeeper://127.0.0.1:2181");
        GenericRpcService genericRpcService = new GenericRpcServiceImpl();
        String[] paramTypes = new String[]{"com.zbt.cache.service.dubbo.dto.DemoRequestDTO"};
        Object[] params = new Object[1];
        DemoRequestDTO demoRequestDTO = new DemoRequestDTO();
        demoRequestDTO.setId(1);
        demoRequestDTO.setName("zhao");
        params[0] = demoRequestDTO;
        GenericRpcReq req = GenericRpcReq.builder()
                .applicationConfig(applicationConfig)
                .registryConfig(registryConfig)
                .interfaceName("com.zbt.cache.service.dubbo.producer.ProviderService")
                .method("getData")
                .paramTypes(paramTypes)
                .params(params)
                .blockHandler("ProviderServiceGetDataHandler")
                .referenceConfigId("1")
                .build();
        Object res = genericRpcService.invoke(req);
        log.info("结果 ::{}", JacksonUtils.toString(res));

    }
}
