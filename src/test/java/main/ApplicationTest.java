package main;

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
 * date 2022/02/05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private MessageService messageService;

    @Test
    public void testSaveMessage() {
        Message message = new Message();
        message.setId(1L);
        message.setTitle("标题");
        message.setContent("内容");
        messageService.saveMessageCache(message);

        Message message1 = messageService.getMessage(1L);
        Assert.assertNotNull(message1);
    }
}
