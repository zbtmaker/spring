package start.cache.service;

import com.zbt.cache.service.kafka.AlgorithmKafkaProducer;
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
public class AlgorithmKafkaProducerTest {

    @Autowired
    private AlgorithmKafkaProducer algorithmKafkaProducer;

    @Test
    public void testSend() {
        for (int i = 0; i < 2400; i++) {
            algorithmKafkaProducer.send("test", String.valueOf(i));
        }

        System.out.println();
    }
}
