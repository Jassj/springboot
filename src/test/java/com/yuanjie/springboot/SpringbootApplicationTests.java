package com.yuanjie.springboot;

import com.yuanjie.springboot.common.properties.StudentProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    StudentProperties studentProperties;

    @Test
    void contextLoads() {
        System.out.println(studentProperties.toString());
    }

}
