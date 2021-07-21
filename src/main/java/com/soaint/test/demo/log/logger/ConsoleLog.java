package com.soaint.test.demo.log.logger;

import org.springframework.stereotype.Component;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class ConsoleLog implements ILog {

    private Logger logger = Logger.getLogger("MyLog");
    private ConsoleHandler ch = new ConsoleHandler();

    @Override
    public void writeLog(String logText) {
        logger.addHandler(ch);
        logger.log(Level.INFO, logText);
    }
}
