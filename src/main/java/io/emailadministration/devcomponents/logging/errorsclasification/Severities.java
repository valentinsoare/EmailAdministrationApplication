package io.emailadministration.devcomponents.logging.errorsclasification;

public enum Severities implements ISeverity {

    OFF(0, "OFF"),

    FATAL(1, "FATAL"),

    ERROR(2, "ERROR"),

    WARN(3, "WARN"),

    INFO(4, "INFO"),

    DEBUG(5, "DEBUG"),

    TRACE(6, "TRACE");

    private final int sevAsInteger;
    private final String sevAsLiteral;

    Severities(int sevAsInteger, String sevLiteral) {
        this.sevAsInteger = sevAsInteger;
        this.sevAsLiteral = sevLiteral;
    }

    @Override
    public int getSeverityAsInteger() {
        return sevAsInteger;
    }

    @Override
    public String getSeverityAsLiteral() {
        return sevAsLiteral;
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", getSeverityAsLiteral(), getSeverityAsInteger());
    }
}
