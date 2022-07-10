package com.zbt.cache.service.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author zoubaitao
 * date 2022/07/09
 */
@Service
@Slf4j
public class AlgorithmKafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public AlgorithmKafkaProducer(@Qualifier("kafkaTemplate#test") KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic, String data) {
        ListenableFuture<SendResult<String, String>> callable = kafkaTemplate.send(topic, data);

        callable.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("send message error", ex);
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("send message to topic:{} success, offset:{}", topic, result.getRecordMetadata().offset());
            }
        });
    }

}
