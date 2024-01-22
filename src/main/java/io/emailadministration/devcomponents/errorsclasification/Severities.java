package io.emailadministration.devcomponents.errorsclasification;

public enum Severities implements ISeverity {

    ONE(1, "FATAL"),

    TWO(2, "ERROR"),

    THREE(3, "WARN"),

    FOUR(4, "INFO"),

    FIVE(5, "DEBUG"),

    SIX(6, "TRACE");

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
        return String.format("%d (%s)", getSeverityAsInteger(), getSeverityAsLiteral());
    }
}
