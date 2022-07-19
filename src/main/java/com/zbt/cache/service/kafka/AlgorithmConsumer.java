package com.zbt.cache.service.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.List;

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
    void processConcurrencyMsg(List<String> consumerRecords);

    /**
     * 处理系统消息
     *
     * @param msg
     */
    void processTestMsg(List<String> consumerRecords);
}
