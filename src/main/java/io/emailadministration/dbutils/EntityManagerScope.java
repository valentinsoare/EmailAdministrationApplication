package io.emailadministration.dbutils;

public enum EntityManagerScope {

    EMAIL_SET("email_set"),
    EMAIL_GET("email_get"),
    EMAIL_GENERATE("email_generate"),
    GET_STATS("get_stats"),
    RUN("run_the_app"),
    OPERATIONS_WITH_EMPLOYEE("operations_with_employee"),
    CREATING("creating");

    private final String textContent;

    EntityManagerScope(String textContent) {
        this.textContent = textContent;
    }

    @Override
    public String toString() {
        return textContent;
    }
}
