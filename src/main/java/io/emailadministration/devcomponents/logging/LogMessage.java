package io.emailadministration.devcomponents.logging;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogMessage {
    private String threadName;
    private String clazz;
    private int lineNumber;
    private String method;
    private String sev;
    private String message;
    private String timestamp;
    private String loggerName;

    public LogMessage() {}

    @Override
    public String toString() {
        return String.format("threadName: %s, class: %s, lineNumber: %d, method: %s, severity: %s, message: %s, time: %s, loggerName: %s",
                threadName, clazz, lineNumber, method, sev, message, timestamp, loggerName);
    }
}
