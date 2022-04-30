package start.cache.utils;

import com.zbt.cache.entity.Message;
import com.zbt.cache.utils.JacksonUtil;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zoubaitao
 * date 2022/02/27
 */
public class JacksonUtilTest extends TestCase {

    public void testToString() {
        Message message = new Message();
        message.setId(1L);
        message.setTitle("title 1");
        message.setContent("content 1");
        String str = JacksonUtil.toString(message);
        Message messageParse = JacksonUtil.parseObject(str, Message.class);
        System.out.println(str);
    }

    public void test1() {
        Message message1 = new Message();
        message1.setId(1L);
        Message message2 = new Message();
        message2.setId(2L);
        List<Message> messages = new ArrayList<>();
        messages.add(message1);
        messages.add(message2);
        String str = JacksonUtil.toString(messages);
        List<Message> after = JacksonUtil.parseList(str, Message.class);
        System.out.println(JacksonUtil.toString(after));
    }

    public void test2() {
        Message message1 = new Message();
        message1.setId(1L);
        Message message2 = new Message();
        message2.setId(2L);
        List<Message> messages = new ArrayList<>();
        messages.add(message1);
        messages.add(message2);
        String str = JacksonUtil.toString(messages);
        Set<Message> after = JacksonUtil.parseSet(str, Message.class);
        System.out.println(JacksonUtil.toString(after));
    }

    public void test3() {
        List<String> list = Arrays.stream(new String[]{"1", "1", "2"}).collect(Collectors.toList());
        String str = JacksonUtil.toString(list);
        Set<String> after = JacksonUtil.parseSet(str, String.class);
        System.out.println(JacksonUtil.toString(after));
    }
}
