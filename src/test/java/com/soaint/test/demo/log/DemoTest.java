package com.soaint.test.demo.log;

import com.soaint.test.demo.log.repository.LogRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class DemoTest {

    @Autowired
    Demo demo;

    @Autowired
    LogRepository logRepository;

    @Test
    void logMessage() throws Exception {
        long count = logRepository.count();
        demo.LogMessage("test de log", true, true, true);
        assertEquals(logRepository.count(), count + 1);
    }
}
