package io.emailadministration.devcomponents.errorsclasification;

import java.util.List;

public interface ICustomError {
    String getContent();
    String getName();
    int getSeverity();
    int getNumberOfErrorsDefined();
    List<ICustomError> allErrorsWithinCategory();
}
