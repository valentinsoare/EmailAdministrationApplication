package io.emailadministration.devcomponents.logging;

import io.emailadministration.devcomponents.Component;
import io.emailadministration.devcomponents.logging.errorsclasification.ISeverity;

public interface ILogging extends Component<ILogging> {
    String writeToFile(LogMessage message);
    String printToConsole(LogMessage message);
    boolean setLogLevel(ISeverity logLevel);
}
