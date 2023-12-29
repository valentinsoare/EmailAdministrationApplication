package io.emailadministration.devcomponents.errorsclasification;

public enum Severities implements ISeverity {

    ONE(1, "Complete Outage"),

    TWO(2, "Critical"),

    THREE(3, "High"),

    FOUR(4, "Medium"),

    FIVE(5, "Low");

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
