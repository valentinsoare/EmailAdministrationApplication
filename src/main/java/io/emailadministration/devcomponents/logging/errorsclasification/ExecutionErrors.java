package io.emailadministration.devcomponents.logging.errorsclasification;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public enum ExecutionErrors implements ICustomError {

    LOAD_CONSOLE_ISSUE("load_console_issue", Severities.FATAL,"EXEC: Cannot load the console!");

    private String name;
    private String content;
    private ISeverity severity;

    ExecutionErrors(String name, ISeverity severity, String content) {
        this.name = name;
        this.severity = severity;
        this.content = content;
    }

    @Override
    public int getNumberOfErrorsDefined() {
        return allErrorsWithinCategory().size();
    }

    @Override
    public List<ICustomError> allErrorsWithinCategory() {
        return  new ArrayList<>(Arrays.asList(LOAD_CONSOLE_ISSUE));
    }

    @Override
    public ICustomError addAdditionalMessage(String additionalMessage) {
        this.content = String.format("%s, additionalMessage: %s", this.content, additionalMessage);
        return this;
    }

    @Override
    public String toString() {
        return content;
    }
}
