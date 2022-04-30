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
 * date 2022/02/06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageServiceTest {

    @Autowired
    private MessageService messageService;

    @Test
    public void testSaveMessage() {
        Message message = new Message();
        message.setId(1L);
        message.setTitle("标题");
        message.setContent("内容");
        messageService.saveMessageCache(message);

        Assert.assertNotNull(messageService.getMessage(1L));
    }

    @Test
    public void testEvictCacheById() {
        Message message = new Message();

        Long id = 1L;
        message.setId(id);
        message.setTitle("标题");
        message.setContent("内容");
        // 存入缓存
        messageService.saveMessageCache(message);

        // 从缓存中获取对象
        Message cachedMessage = messageService.getMessage(id);
        Assert.assertNotNull(cachedMessage);

        // 从缓存中剔除对象
        messageService.evictCacheById(id);

        // 再一次获取缓存对象时为空
        Assert.assertNull(messageService.getMessage(id));
    }

    @Test
    public void testEvictAllCache() {
        Message message1 = new Message();
        Long id1 = 1L;
        message1.setId(id1);
        message1.setTitle("标题1");
        message1.setContent("内容1");
        messageService.saveMessageCache(message1);
        Assert.assertNotNull(messageService.getMessage(id1));

        Message message2 = new Message();
        Long id2 = 2L;
        message2.setId(id2);
        message2.setTitle("标题2");
        message2.setContent("内容2");
        messageService.saveMessageCache(message2);
        Assert.assertNotNull(messageService.getMessage(id2));

        messageService.evictAllCache();

        Assert.assertNull(messageService.getMessage(id1));
        Assert.assertNull(messageService.getMessage(id2));
    }

    @Test
    public void testGetMessage() {
        Message message1 = new Message();
        Long id1 = 1L;
        message1.setId(id1);
        message1.setTitle("标题1");
        message1.setContent("内容1");
        messageService.saveMessageCache(message1);
        Assert.assertNotNull(messageService.getMessage(id1));
    }


}
