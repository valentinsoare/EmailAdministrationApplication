package io.emailadministration.dbutils;

public enum EntityManagerScope {
    GET_STATS("get_stats"),
    OPERATIONS_WITH_EMPLOYEE("operations_with_employee"),
    OPERATIONS_WITH_DEPARTMENT("operations_with_department");

    private final String textContent;

    EntityManagerScope(String textContent) {
        this.textContent = textContent;
    }

    @Override
    public String toString() {
        return textContent;
    }
}
