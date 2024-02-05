package io.emailadministration.devcomponents.logging.errorsclasification;

import java.util.List;

public interface ICustomError {
    String getContent();
    String getName();
    ISeverity getSeverity();
    int getNumberOfErrorsDefined();
    List<ICustomError> allErrorsWithinCategory();
    ICustomError addAdditionalMessage(String additionalMessage);
}
