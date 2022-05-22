package start.cache.service;

import com.zbt.cache.entity.Message;
import com.zbt.cache.service.MessageService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zoubaitao
 * date 2022/05/21
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheExpireTest {

    @Autowired
    private MessageService messageService;

    @Test
    public void evictTest() {
        for (long i = 0; i < 7; i++) {
            Message message = new Message();
            message.setId(i);
            message.setTitle("title" + i);
            message.setContent("content" + i);
            messageService.saveMessageCache(message);
        }
        for (long i = 0; i < 3; i++) {
            Message message = messageService.getMessage(i);
            Assert.assertNotNull(message);
        }
    }
}
