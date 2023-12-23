package io.emailadministration.operationsWithDB.applicationAdminQueries;

public enum QueriesForDbInfo {
    NUMBER_OF_RECORDS(""),
    NAME_OF_THE_DATABASE(""),
    DESCRIPTION_OF_THE_DB_TABLES("");

    private final String textContent;

    QueriesForDbInfo(String textContent) {
        this.textContent = textContent;
    }

    @Override
    public String toString() {
        return textContent;
    }
}
