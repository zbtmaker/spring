package com.zbt.cache.service.impl;

import com.zbt.cache.service.kafka.AlgorithmConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import zbtmaker.boot.common.util.JacksonUtils;

import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zoubaitao
 * date 2022/06/04
 */
@Service
@Slf4j
public class AlgorithmConsumerImpl implements AlgorithmConsumer {

    private static final ThreadPoolExecutor THREAD_POOL = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
            Runtime.getRuntime().availableProcessors() * 2, 100,
            TimeUnit.SECONDS, new SynchronousQueue<>(), new ThreadPoolExecutor.CallerRunsPolicy());

    @KafkaListener(topics = {"concurrency"}, groupId = "concurrencyGroup", containerFactory = "containerFactory#local")
    @Override
    public void processConcurrencyMsg(List<String> consumerRecords) {
        log.error("start consumer topic:{}, message size:{}, message info:{}", "concurrency", consumerRecords.size(), JacksonUtils.toString(consumerRecords));
        for (String str : consumerRecords) {
            THREAD_POOL.submit(() -> {
                try {
                    log.error("consumer topic:{}, message info:{}", "concurrency", str);
                    Thread.sleep(3000);
                } catch (Exception ex) {
                    log.error("consumer sleep error", ex);
                }
            });
        }
        log.error("end consumer topic:{}, message size:{}, message info:{}", "concurrency", consumerRecords.size(), JacksonUtils.toString(consumerRecords));
    }

    @KafkaListener(topics = {"test"}, groupId = "testGroup", containerFactory = "containerFactory#local")
    @Override
    public void processTestMsg(List<String> consumerRecords) {
        log.error("start consumer topic:{}, message size:{}, message info:{}", "test", consumerRecords.size(), JacksonUtils.toString(consumerRecords));

        long startTime = System.currentTimeMillis();
        for (String str : consumerRecords) {
            try {
                log.error("consumer topic:{}, message info:{}", "test", str);
                Thread.sleep(10);
            } catch (Exception ex) {
                log.error("consumer sleep error", ex);
            }
        }
        log.error("consumer topic:{}, message size:{}, cost time:{}, message info:{}", "test", consumerRecords.size(), System.currentTimeMillis() - startTime, JacksonUtils.toString(consumerRecords));

    }
}
