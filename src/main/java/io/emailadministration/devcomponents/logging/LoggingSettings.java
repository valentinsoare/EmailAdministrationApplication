package io.emailadministration.devcomponents.logging;

import io.emailadministration.devcomponents.logging.errorsclasification.ISeverity;
import io.emailadministration.devcomponents.logging.errorsclasification.Severities;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

@Getter
public class LoggingSettings {
    private Logger logger;
    private TypeOfFormat typeOfFormat;
    private ISeverity logLevel;

    public LoggingSettings() {}

    public LoggingSettings(Class<?> clazz) {
        this.logger = LogManager.getLogger(clazz);
        this.typeOfFormat = TypeOfFormat.JSON;
        setLogLevel(Severities.THREE);
    }

    public LoggingSettings(Class<?> clazz, TypeOfFormat typeOfFormat, ISeverity logLevel) {
        this.logger = LogManager.getLogger(clazz);
        this.typeOfFormat = typeOfFormat;
        setLogLevel(logLevel);
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public void setTypeOfFormat(TypeOfFormat typeOfFormat) {
        this.typeOfFormat = typeOfFormat;
    }

    public void setLogLevel(ISeverity logLevel) {
        this.logLevel = logLevel;
        Configurator.setLevel(logger.getName(), logLevel.toString());
    }

    @Override
    public String toString() {
        return String.format("LoggingSettings [ loggerName: %s, format: %s, level: %s ]",
                logger.getName(), typeOfFormat, logLevel);
    }
}
