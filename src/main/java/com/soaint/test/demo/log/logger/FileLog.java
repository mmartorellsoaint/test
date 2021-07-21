package com.soaint.test.demo.log.logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class FileLog implements ILog {

    private Logger logger = Logger.getLogger("MyLog");
    private FileHandler fh;

    @Value("${app.logFileFolder}")
    private String userBucketPath;

    private FileHandler initFileLog() throws IOException {
        if(fh == null) {
            File logFile = new File(userBucketPath + "logFile.txt");
            if (!logFile.exists()) {
                logFile.createNewFile();
            }
            fh = new FileHandler(userBucketPath + "logFile.txt");
        }
        return fh;
    }

    @Override
    public void writeLog(String logText) throws IOException {
        logger.addHandler(initFileLog());
        logger.log(Level.INFO, logText);
    }
}
