package com.zbt.cache.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;

/**
 * @author zoubaitao
 * date 2022/06/04
 */

public interface AlgorithmConsumer {

    /**
     * 处理运营消息
     *
     * @param msg
     */
    void processOperatorMsg(ConsumerRecord<String, String> msg);

    /**
     * 处理系统消息
     *
     * @param msg
     */
    void processSystemMsg(ConsumerRecord<String, String> msg);
}
