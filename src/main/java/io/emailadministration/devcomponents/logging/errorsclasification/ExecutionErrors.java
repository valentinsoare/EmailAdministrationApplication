package io.emailadministration.devcomponents.logging.errorsclasification;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public enum ExecutionErrors implements ICustomError {

    LOAD_CONSOLE_ISSUE("load_console_issue", 1,"EXEC: Cannot load the console!",
            LocalDate.now(), LocalTime.now());

    private String name;
    private String content;
    private int severity;
    private LocalDate onWhichDate;
    private LocalTime onWhichTime;

    ExecutionErrors(String name, int severity, String content, LocalDate onWhichDate, LocalTime onWhichTime) {
        this.name = name;
        this.severity = severity;
        this.content = content;
        this.onWhichDate = onWhichDate;
        this.onWhichTime = onWhichTime;
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
        return String.format("%s [%s - %s]", content, onWhichDate, onWhichTime);
    }
}
