package io.emailadministration.configurationmapper;

import io.emailadministration.customdatastructureandoperationsonthem.operationswithdatastructures.OperationsOnMap;
import io.emailadministration.devcomponents.logging.TypeOfFormat;
import io.emailadministration.devcomponents.logging.errorsclasification.Severities;
import io.emailadministration.printing.CustomPrinting;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class LoggingConfig {
    private String loggerName;
    private TypeOfFormat logFormat;
    private Severities logLevel;
    private String logDirectory;
    private String loggingFile;

    private int logFileSizeLimit;
    private LogFileSizeMeasurement logFileSizeMeasurement;

    private LogFileTypeOfTimeLimit logFileTypeOfTimeLimit;
    private int logFileTimeLimit;

    public LoggingConfig() {}

    @Override
    public String toString() {
        Map<String, LoggingConfig> objectLoggingConfigMap = OperationsOnMap.putObjectAttributes(this);
        return CustomPrinting.of(objectLoggingConfigMap, "");
    }
}
