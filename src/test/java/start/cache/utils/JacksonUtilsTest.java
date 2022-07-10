package start.cache.utils;

import com.zbt.cache.entity.Message;
import junit.framework.TestCase;
import zbtmaker.boot.common.util.JacksonUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zoubaitao
 * date 2022/02/27
 */
public class JacksonUtilsTest extends TestCase {

    public void testToString() {
        Message message = new Message();
        message.setId(1L);
        message.setTitle("title 1");
        message.setContent("content 1");
        String str = JacksonUtils.toString(message);
        Message messageParse = JacksonUtils.parseObject(str, Message.class);
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
        String str = JacksonUtils.toString(messages);
        List<Message> after = JacksonUtils.parseList(str, Message.class);
        System.out.println(JacksonUtils.toString(after));
    }

    public void test2() {
        Message message1 = new Message();
        message1.setId(1L);
        Message message2 = new Message();
        message2.setId(2L);
        List<Message> messages = new ArrayList<>();
        messages.add(message1);
        messages.add(message2);
        String str = JacksonUtils.toString(messages);
        Set<Message> after = JacksonUtils.parseSet(str, Message.class);
        System.out.println(JacksonUtils.toString(after));
    }

    public void test3() {
        List<String> list = Arrays.stream(new String[]{"1", "1", "2"}).collect(Collectors.toList());
        String str = JacksonUtils.toString(list);
        Set<String> after = JacksonUtils.parseSet(str, String.class);
        System.out.println(JacksonUtils.toString(after));
    }
}
