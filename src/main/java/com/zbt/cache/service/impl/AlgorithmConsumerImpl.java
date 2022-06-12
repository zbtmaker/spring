package com.zbt.cache.service.impl;

import com.zbt.cache.service.AlgorithmConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author zoubaitao
 * date 2022/06/04
 */
@Service
public class AlgorithmConsumerImpl implements AlgorithmConsumer {


    @KafkaListener(topics = {"operator_push_topic"}, groupId = "operator_group")
    @Override
    public void processOperatorMsg(ConsumerRecord<String, String> msg) {

    }

    @KafkaListener(topics = {"system_push_topic"}, groupId = "system_group")
    @Override
    public void processSystemMsg(ConsumerRecord<String, String> msg) {

    }
}
