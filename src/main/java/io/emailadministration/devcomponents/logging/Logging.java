package io.emailadministration.devcomponents.logging;

import io.emailadministration.devcomponents.logging.errorsclasification.ISeverity;

public class Logging implements ILogging {

    private LoggingSettings loggingSettings;

    public Logging() {}

    public Logging(LoggingSettings loggingSettings) {
        this.loggingSettings = loggingSettings;
    }

    @Override
    public String getTypeOfObject() {
        return this.getClass().getSimpleName();
    }

    @Override
    public ILogging getPresentObject() {
        return null;
    }

    @Override
    public String writeToFile(LogMessage message) {
        return null;
    }

    @Override
    public String printToConsole(LogMessage message) {
        return null;
    }

    @Override
    public boolean setLogLevel(ISeverity logLevel) {
        this.loggingSettings.setLogLevel(logLevel);
        return true;
    }
}
