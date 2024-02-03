package io.emailadministration.devcomponents.logging.errorsclasification;

import lombok.Getter;

import java.util.List;

@Getter
public enum IntegrityErrors implements ICustomError {
    ;
    private String name;
    private String content;
    private int severity;

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
    public ICustomError addAdditionalMessage(String additionalMessage) {
        this.content = String.format("%s, additionalMessage: %s", this.content, additionalMessage);
        return this;
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
