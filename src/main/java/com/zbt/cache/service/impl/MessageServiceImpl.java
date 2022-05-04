package com.zbt.cache.service.impl;

import com.zbt.cache.entity.Message;
import com.zbt.cache.service.MessageService;
import com.zbt.cache.utils.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * @author zoubaitao
 * date 2022/02/05
 */
@Service
@Slf4j
public class MessageServiceImpl implements MessageService , ApplicationContextAware {

    private   ApplicationContext applicationContext;

    @Override
    public Message getMessageWithoutCache(Long id) {
        log.info("access getMessageWithoutCache method, parameter::{}", id);
        // 此时调用的是被增强的类MessageServiceImpl$Enhancer，然后走的是被增强的方法，如果使用this.getMessage(id),此时调用的是原来的对象MessageService
        MessageService messageService = applicationContext.getBean(MessageService.class);
        return messageService.getMessage(id);
    }

    @Override
    @Cacheable(cacheNames = "message", key = "#id", unless = "#result=null ")
    public Message getMessage(Long id) {
        log.info("access getMessage method, parameter::{}", id);
        return null;
    }

    @Override
    @CachePut(cacheNames = "message", key = "#message.id")
    public Message saveMessageCache(Message message) {
        log.info("access saveMessageCache method, parameter::{}", JacksonUtil.toString(message));
        return message;
    }

    @Override
    @CacheEvict(cacheNames = "message", key = "#id")
    public void evictCacheById(Long id) {
        log.info("access evictMessage method, parameter::{}", id);
    }

    @Override
    @CacheEvict(cacheNames = "message", allEntries = true)
    public void evictAllCache() {
        log.info("access evictAllCache method");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
