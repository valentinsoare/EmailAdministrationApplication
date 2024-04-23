package io.emailadministration.devcomponents.logging;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogMessage {
    private int threadNumber;
    private String clazz;
    private String method;
    private String severity;
    private String message;
    private String timestamp;
    private String loggerName;

    public LogMessage() {}

    @Override
    public String toString() {
        return String.format("threadName: %s, class: %s, method: %s, severity: %s, message: %s, time: %s, loggerName: %s",
                threadNumber, clazz, method, severity, message, timestamp, loggerName);
    }
}
