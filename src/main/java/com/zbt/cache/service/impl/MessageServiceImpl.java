package com.zbt.cache.service.impl;

import com.zbt.cache.entity.Message;
import com.zbt.cache.service.MessageService;
import com.zbt.cache.utils.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author zoubaitao
 * date 2022/02/05
 */
@Service
@Slf4j
public class MessageServiceImpl implements MessageService {

    @Override
    @Cacheable(cacheNames = "message", key = "#id", unless = "#result=null ")
    public Message getMessage(Long id) {
        log.info("access getMessage method, parameter::{}", id);
        return null;
    }

    @Override
    @CachePut(cacheNames = "message", key = "#message.id")
    public Message saveMessageCache(Message message) {
        log.error("access saveMessageCache method, parameter::{}", JacksonUtil.toString(message));
        return message;
    }

    @Override
    @CacheEvict(cacheNames = "message", key = "#id")
    public void evictCacheById(Long id) {
        log.error("access evictMessage method, parameter::{}", id);
    }

    @Override
    @CacheEvict(cacheNames = "message", allEntries = true)
    public void evictAllCache() {
        log.error("access evictAllCache method");
    }
}
