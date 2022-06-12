package start.cache.service;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import junit.framework.TestCase;

import java.util.Random;
import java.util.concurrent.ExecutionException;

/**
 * @author zoubaitao
 * date 2022/06/01
 */
public class GuavaCacheTest extends TestCase {
    public void test1() throws ExecutionException {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(5)
                .build(new CacheLoader<String, String>() {
                    public String load(String key) {
                        return key + "#" + new Random().nextInt(50);
                    }
                });
        for (int i = 0; i < 10; i++) {
            String res = cache.get(String.valueOf(i));
            System.out.println(res);
        }
        System.out.println("----------------------------------");
        for (int i = 9; i >= 0; i--) {
            String res = cache.get(String.valueOf(i));
            System.out.println(res);
        }
    }
}
