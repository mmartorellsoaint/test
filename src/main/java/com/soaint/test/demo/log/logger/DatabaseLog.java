package com.soaint.test.demo.log.logger;

import com.soaint.test.demo.log.domain.LogModel;
import com.soaint.test.demo.log.repository.LogRepository;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Component
public class DatabaseLog implements ILog {

    private final LogRepository logRepository;

    private String t;

    public DatabaseLog(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public void writeLog(String logText) {
        LogModel l = new LogModel(null, logText, t);
        logRepository.save(l);
    }
}
