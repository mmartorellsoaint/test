package com.soaint.test.demo.log.logger;

import java.io.IOException;
import java.util.logging.Logger;

public interface ILog {

    void writeLog(String logText) throws IOException;
}
