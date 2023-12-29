package io.emailadministration.devcomponents.errorsclasification;

import lombok.Getter;

import java.util.List;

@Getter
public enum IntegrityErrors implements ICustomError {
    ;
    private final String name;
    private final String content;
    private final int severity;

    IntegrityErrors(String name, String content, int severity) {
        this.name = name;
        this.content = content;
        this.severity = severity;
    }


    @Override
    public int getNumberOfErrorsDefined() {
        return 0;
    }

    @Override
    public List<ICustomError> allErrorsWithinCategory() {
        return null;
    }

    @Override
    public String toString() {
        return this.content;
    }
}
