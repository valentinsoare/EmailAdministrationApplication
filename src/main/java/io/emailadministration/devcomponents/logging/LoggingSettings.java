package io.emailadministration.devcomponents.logging;

import io.emailadministration.devcomponents.logging.errorsclasification.ISeverity;
import io.emailadministration.devcomponents.logging.errorsclasification.Severities;
import lombok.Getter;

@Getter
public class LoggingSettings {
    private String clazz;
    private TypeOfFormat typeOfFormat;
    private ISeverity logLevel;

    public LoggingSettings() {}

    public LoggingSettings(Class<?> clazz) {
        this.clazz = clazz.getName();
        this.typeOfFormat = TypeOfFormat.JSON;
        this.logLevel = Severities.WARN;
    }

    public LoggingSettings(Class<?> clazz, TypeOfFormat typeOfFormat, ISeverity logLevel) {
        this.clazz = clazz.getName();
        this.typeOfFormat = typeOfFormat;
        this.logLevel = logLevel;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public void setTypeOfFormat(TypeOfFormat typeOfFormat) {
        this.typeOfFormat = typeOfFormat;
    }

    public void setLogLevel(ISeverity logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    public String toString() {
        return String.format("LoggingSettings [ loggerName: %s, format: %s, level: %s ]",
                clazz, typeOfFormat, logLevel);
    }
}
