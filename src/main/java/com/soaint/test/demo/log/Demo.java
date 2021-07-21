package com.soaint.test.demo.log;

import com.soaint.test.demo.log.logger.ConsoleLog;
import com.soaint.test.demo.log.logger.DatabaseLog;
import com.soaint.test.demo.log.logger.FileLog;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.Date;

@Component
class Demo {

    @Value("${app.log.logToFile}")
    private boolean logToFile;
    @Value("${app.log.logToConsole}")
    private boolean logToConsole;
    @Value("${app.log.logMessage}")
    private boolean logMessage;
    @Value("${app.log.logWarning}")
    private boolean logWarning;
    @Value("${app.log.logError}")
    private boolean logError;
    @Value("${app.log.logToDatabase}")
    private boolean logToDatabase;

    private final ConsoleLog consoleLog;
    private final DatabaseLog databaseLog;
    private final FileLog fileLog;

    public Demo(ConsoleLog consoleLog, DatabaseLog databaseLog, FileLog fileLog) {
        this.consoleLog = consoleLog;
        this.databaseLog = databaseLog;
        this.fileLog = fileLog;
    }

    public void LogMessage(String messageText, boolean message, boolean warning, boolean error) throws Exception {
        if (messageText == null || messageText.length() == 0) {
            return;
        }
        messageText = messageText.trim();
        if (!logToConsole && !logToFile && !logToDatabase) {
            throw new Exception("Invalid configuration");
        }
        if ((!logError && !logMessage && !logWarning) || (!message && !warning && !error)) {
            throw new Exception("Error or Warning or Message must be specified");
        }

        int t = 0;
        if (message && logMessage) {
            t = 1;
        }

        if (error && logError) {
            t = 2;
        }

        if (warning && logWarning) {
            t = 3;
        }

        String l = "";

        if (error && logError) {
            l = l + "error " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
        }

        if (warning && logWarning) {
            l = l + "warning " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
        }

        if (message && logMessage) {
            l = l + "message " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
        }

        if (logToFile) {
            fileLog.writeLog(l);
        }

        if (logToConsole) {
            consoleLog.writeLog(l);
        }

        if (logToDatabase) {
            databaseLog.setT(String.valueOf(t));
            databaseLog.writeLog(l);
        }
    }
}
