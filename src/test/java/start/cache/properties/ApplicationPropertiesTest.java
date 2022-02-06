package start.cache.properties;

import com.zbt.cache.config.ApplicationProperties;
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
public class ApplicationPropertiesTest {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Test
    public void test1() {
        System.out.println(applicationProperties.toString());
        Assert.assertNotNull(applicationProperties);
    }
}
