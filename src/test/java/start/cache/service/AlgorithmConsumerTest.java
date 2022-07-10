package start.cache.service;

import com.zbt.cache.service.kafka.AlgorithmConsumer;
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
public class AlgorithmConsumerTest {

    @Autowired
    private AlgorithmConsumer algorithmConsumer;


    @Test
    public void testProcessSystemMsg() {
        while (true) {

        }
    }
}
