package io.emailadministration.devcomponents.logging;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Getter
@Setter
public class LoggingSettings {
    private Logger logger;
    private LogLevel level;
    private TypeOfLog typeOfLog;

    public LoggingSettings() {}

    public LoggingSettings(Class<?> clazz) {
        this.logger = LogManager.getLogger(clazz);
        this.level = LogLevel.WARN;
        this.typeOfLog = TypeOfLog.JSON;
    }

    public LoggingSettings(Class<?> clazz, LogLevel level, TypeOfLog typeOfLog) {
        this.logger = LogManager.getLogger(clazz);
        this.level = level;
        this.typeOfLog = typeOfLog;
    }

    public LoggingSettings(Logger logger, LogLevel level, TypeOfLog typeOfLog) {
        this.logger = logger;
        this.level = level;
        this.typeOfLog = typeOfLog;
    }
}
