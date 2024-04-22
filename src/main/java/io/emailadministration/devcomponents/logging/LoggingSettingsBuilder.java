package io.emailadministration.devcomponents.logging;

public class LoggingSettingsBuilder {

    private LoggingSettings loggingSettings;

    public LoggingSettingsBuilder() {
        this.loggingSettings = new LoggingSettings();
    }

    public LoggingSettingsBuilder setupClazz(Class<?> clazz) {
        this.loggingSettings.setClazz(clazz.toString());
        return this;
    }

    public LoggingSettingsBuilder setupLoggerName(String loggerName) {
        this.loggingSettings.setLoggerName(loggerName);
        return this;
    }

    public LoggingSettingsBuilder setupTypeOfFormat(TypeOfFormat typeOfFormat) {
        this.loggingSettings.setTypeOfFormat(typeOfFormat);
        return this;
    }






}
