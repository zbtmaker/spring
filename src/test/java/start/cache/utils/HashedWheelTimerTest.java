package start.cache.utils;

import io.netty.util.HashedWheelTimer;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author zoubaitao
 * date 2022/06/19
 */
@Slf4j
public class HashedWheelTimerTest extends TestCase {
    private final CountDownLatch countDownLatch = new CountDownLatch(2);

    public void test1() {
        HashedWheelTimer hashedWheelTimer = new HashedWheelTimer(1, TimeUnit.SECONDS, 16);
        hashedWheelTimer.newTimeout(timeout -> {
            log.info("--------task1 execute---------");
            countDownLatch.countDown();
        }, 500, TimeUnit.MILLISECONDS);

        hashedWheelTimer.newTimeout(timeout -> {
            log.info("--------task2 execute---------");
            countDownLatch.countDown();
        }, 500, TimeUnit.MILLISECONDS);

        try {
            countDownLatch.await();
        } catch (Exception ex) {
            log.error("CountDownLatch.await execute error!", ex);
        }
        hashedWheelTimer.stop();
    }
}
