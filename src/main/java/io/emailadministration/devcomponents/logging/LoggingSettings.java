package io.emailadministration.devcomponents.logging;

import io.emailadministration.configurationmapper.LogFileSizeMeasurement;
import io.emailadministration.configurationmapper.LogFileTypeOfTimeLimit;
import io.emailadministration.customdatastructureandoperationsonthem.operationswithdatastructures.OperationsOnMap;
import io.emailadministration.devcomponents.logging.errorsclasification.ISeverity;
import io.emailadministration.devcomponents.logging.errorsclasification.Severities;
import io.emailadministration.printing.CustomPrinting;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class LoggingSettings {
    private String clazz;
    private String loggerName;
    private TypeOfFormat typeOfFormat;
    private ISeverity logLevel;
    private String logDirectory;
    private String loggingFile;
    private int logFileSizeLimit;
    private LogFileSizeMeasurement logFileSizeMeasurement;
    private LogFileTypeOfTimeLimit logFileTypeOfTimeLimit;
    private int logFileTimeLimit;

    public LoggingSettings() {}

    public LoggingSettings(Class<?> clazz) {
        this.clazz = clazz.getName();
        this.loggerName = "EmailAppAdm";
        this.typeOfFormat = TypeOfFormat.JSON;
        this.logLevel = Severities.WARN;
        this.logDirectory = "/var/log/messages/";
        this.loggingFile = "emailAdm.log";
        this.logFileSizeLimit = 5;
        this.logFileSizeMeasurement = LogFileSizeMeasurement.MB;
        this.logFileTypeOfTimeLimit = LogFileTypeOfTimeLimit.DAYS;
        this.logFileTimeLimit = 72;
    }

    public LoggingSettings(Class<?> clazz, TypeOfFormat typeOfFormat, Severities logLevel) {
        this.clazz = clazz.getName();
        this.loggerName = "EmailAppAdm";
        this.typeOfFormat = typeOfFormat;
        this.logLevel = logLevel;
        this.logDirectory = "/var/log/messages/";
        this.loggingFile = "emailAdm.log";
        this.logFileSizeLimit = 5;
        this.logFileSizeMeasurement = LogFileSizeMeasurement.MB;
        this.logFileTypeOfTimeLimit = LogFileTypeOfTimeLimit.DAYS;
        this.logFileTimeLimit = 72;
    }

    public LoggingSettings(String loggerName, String clazz, TypeOfFormat typeOfFormat, ISeverity logLevel, String logDirectory,
                           String loggingFile, int logFileSizeLimit, LogFileSizeMeasurement logFileSizeMeasurement,
                           LogFileTypeOfTimeLimit logFileTypeOfTimeLimit, int logFileTimeLimit) {
        this.clazz = clazz;
        this.loggerName = loggerName;
        this.typeOfFormat = typeOfFormat;
        this.logLevel = logLevel;
        this.logDirectory = logDirectory;
        this.loggingFile = loggingFile;
        this.logFileSizeLimit = logFileSizeLimit;
        this.logFileSizeMeasurement = logFileSizeMeasurement;
        this.logFileTypeOfTimeLimit = logFileTypeOfTimeLimit;
        this.logFileTimeLimit = logFileTimeLimit;
    }

    @Override
    public String toString() {
        Map<String, LoggingSettings> objectLoggingSettingsMap = OperationsOnMap.putObjectAttributes(this);
        return CustomPrinting.of(objectLoggingSettingsMap, "");
    }
}
