package com.yuanjie.springboot.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yuanjie.springboot.config.sentinel.SentinelConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SentinelConfigTest {

    @Autowired
    SentinelConfig sentinelConfig;

    @Test
    public void test() throws InterruptedException {
        while (true) {
            Thread.sleep(500);
            // 1.5.0 版本开始可以直接利用 try-with-resources 特性
            try (Entry entry = SphU.entry("test")) {
                // 被保护的逻辑
                System.out.println("hello world");
            } catch (BlockException e) {
                // 处理被流控的逻辑
                System.out.println("blocked!");
            }
        }
    }

}
