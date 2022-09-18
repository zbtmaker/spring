package start.cache.service;

import com.zbt.cache.service.kafka.AlgorithmKafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zoubaitao
 * date 2022/07/10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AlgorithmKafkaProducerTest {

    @Autowired
    private AlgorithmKafkaProducer algorithmKafkaProducer;

    @Test
    public void testSend() {
        String topic = "test";
        for (int i = 0; i < 10; i++) {
            if (i % 3 == 0) {
                try {
                    Thread.sleep(4000);
                    log.info("start sleep -----------");
                } catch (Exception ex) {
                    log.error("sleep error", ex);
                }

            }
            algorithmKafkaProducer.send(topic, String.valueOf(i));
        }
        log.info("producer message to topic::{} success", topic);
    }

    @Test
    public void test2() {
        String topic = "concurrency";
        for (int i = 0; i < 1000; i++) {
            algorithmKafkaProducer.send(topic, String.valueOf(i));
        }
        log.info("producer message to topic::{} success", topic);
        try {
            Thread.sleep(100);
        } catch (Exception ex) {
            log.error("producer messag to topic::{}", topic);
        }

    }
}
