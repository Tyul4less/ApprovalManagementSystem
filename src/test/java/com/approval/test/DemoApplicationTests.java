package com.approval.test;

import com.approval.test.hr.mapper.HRMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private HRMapper hrMapper;

    @Test
    void contextLoads() {
        hrMapper.selectHRInfo();
    }

}
