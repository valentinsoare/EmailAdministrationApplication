package io.emailadministration.DButils;

import lombok.Getter;

@Getter
public enum DatabaseUtilInfo {
    UNIT_PERSISTENCE_NAME("lightweightEmailApp");

    private final String textRepresentative;

    DatabaseUtilInfo(String textRepresentative) {
        this.textRepresentative = textRepresentative;
    }

    @Override
    public String toString() {
        return textRepresentative;
    }
}
