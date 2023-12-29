package io.emailadministration.devcomponents.errorsclasification;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public enum ExecutionErrors implements ICustomError {

    LOAD_CONSOLE_ISSUE("load_console_issue", 1,
            String.format("EXEC_ERROR, SEV: %s - Cannot load the console!", Severities.ONE));

    private final String name;
    private final String content;
    private final int severity;

    ExecutionErrors(String name, int severity, String content) {
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
    public String toString() {
        return this.content;
    }
}
