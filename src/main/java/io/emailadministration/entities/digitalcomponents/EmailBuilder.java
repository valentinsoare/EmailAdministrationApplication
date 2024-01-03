package io.emailadministration.entities.digitalcomponents;

import java.math.BigDecimal;

public class EmailBuilder {

    private Email email;

    public EmailBuilder(User user) {
        this.email = user.getEmail();
    }

    public EmailBuilder setupPrimaryEmailAddress(String emailAddress) {
        email.setPrimaryEmailAddress(emailAddress);
        return this;
    }

    public EmailBuilder setupSecondaryEmailAddress(String emailAddress) {
        email.setSecondaryEmailAddress(emailAddress);
        return this;
    }

    public EmailBuilder setupMailboxCapacity(BigDecimal capacity) {
        email.setMailBoxCapacity(capacity);
        return this;
    }
}
