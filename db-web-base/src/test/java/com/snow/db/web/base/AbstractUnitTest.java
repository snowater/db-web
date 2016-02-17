package com.snow.db.web.base;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:base-application-context.xml"})
public abstract class AbstractUnitTest {
    private static final Logger logger = Logger.getLogger(AbstractUnitTest.class);

//    @Test
//    public void stub() {
//        logger.info("msg from abstract unit test, just ignore this.");
//    }

    @After
    public void teardown() throws InterruptedException {
//        logger.info("unit test complete.");
//        TimeUnit.MILLISECONDS.sleep(500);// 因为有些测试是需要异步插入操作记录的，sleep一下等待线程结束
    }

}
