package io.emailadministration.devcomponents.logging;

import io.emailadministration.devcomponents.logging.errorsclasification.ISeverity;

import java.time.LocalDateTime;

public class LogMessageBuilder {
    private final LogMessage logMessage;

    public LogMessageBuilder() {
        this.logMessage = new LogMessage();
    }

    public LogMessageBuilder setupThreadName(int threadNumber) {
        this.logMessage.setThreadNumber(threadNumber);
        return this;
    }

    public LogMessageBuilder setupClazz(Class<?> clazz) {
        this.logMessage.setClazz(clazz.getSimpleName());
        return this;
    }

    public LogMessageBuilder setupMethodName(String methodName) {
        this.logMessage.setMethod(methodName);
        return this;
    }

    public LogMessageBuilder setupSeverity(ISeverity severity) {
        this.logMessage.setSeverity(severity.getSeverityAsLiteral());
        return this;
    }

    public LogMessageBuilder setupMessage(String message) {
        this.logMessage.setMessage(message);
        return this;
    }


    public LogMessageBuilder setupTimeStamp(LocalDateTime time) {
        this.logMessage.setTimestamp(time.toString());
        return this;
    }

    public LogMessageBuilder setupLoggerName(String loggerName) {
        this.logMessage.setLoggerName(loggerName);
        return this;
    }

    public LogMessage build() {
        return logMessage;
    }
}
