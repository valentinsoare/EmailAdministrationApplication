package io.emailadministration.DButils;

public enum EntityManagerScope {
    EMAIL_SET("email_set"),
    EMAIL_GET("email_get"),
    EMAIL_GENERATE("email_generate");

    private final String textContent;

    EntityManagerScope(String textContent) {
        this.textContent = textContent;
    }

    @Override
    public String toString() {
        return textContent;
    }
}
