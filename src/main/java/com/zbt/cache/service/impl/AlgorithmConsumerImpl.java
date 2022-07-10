package com.zbt.cache.service.impl;

import com.zbt.cache.service.kafka.AlgorithmConsumer;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import zbtmaker.boot.common.util.JacksonUtils;

import java.util.List;

/**
 * @author zoubaitao
 * date 2022/06/04
 */
@Service
@Slf4j
public class AlgorithmConsumerImpl implements AlgorithmConsumer {


    @Override
    public void processOperatorMsg(ConsumerRecord<String, String> msg) {

    }

    @KafkaListener(topics = {"test"}, groupId = "testGroup", containerFactory = "containerFactory#test")
    @Override
    public void processSystemMsg(List<String> consumerRecords) {
        long startTime = System.currentTimeMillis();
        if (consumerRecords == null || consumerRecords.isEmpty()) {
            log.error("consumer topic::{}, the message is null", "test");
            return;
        }
        try {
            Thread.sleep(5000);
        } catch (Exception ex) {
            log.error("consumer sleep error", ex);
        }

        log.info("consumer topic:{}, message size:{}, cost time:{}, message info:{}", "test", consumerRecords.size(), System.currentTimeMillis() - startTime, JacksonUtils.toString(consumerRecords));

    }
}
