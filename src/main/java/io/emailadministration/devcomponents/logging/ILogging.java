package io.emailadministration.devcomponents.logging;

import io.emailadministration.devcomponents.Component;

public interface ILogging extends Component<ILogging> {
    String writeToFile(LogMessage message);
    String printToConsole(LogMessage message);
    boolean setLogLevel(LogLevel level);
}
