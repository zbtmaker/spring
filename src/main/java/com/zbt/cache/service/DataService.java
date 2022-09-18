package com.zbt.cache.service;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @author zoubaitao
 * date 2022/09/11
 */
@Service
public class DataService {

    @DubboReference
    private MessageService messageService;
}
