package com.zbt.cache.service;

import com.zbt.cache.entity.Message;

/**
 * @author zoubaitao
 * date 2022/02/05
 */
public interface MessageService {

    /**
     * 根据主键Id获取Message对象
     *
     * @param id 主键Id
     * @return Message对象
     */
    Message getMessage(Long id);

    /**
     * 保存消息到缓存中
     *
     * @param message 消息体
     * @return Message对象
     */
    Message saveMessageCache(Message message);

    /**
     * 根据主键Id清除缓存
     *
     * @param id 主键Id
     */
    void evictCacheById(Long id);

    /**
     * 清除所有缓存
     */
    void evictAllCache();
}
