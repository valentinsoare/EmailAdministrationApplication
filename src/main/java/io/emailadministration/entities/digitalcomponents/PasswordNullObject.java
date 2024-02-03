package io.emailadministration.entities.digitalcomponents;

public class PasswordNullObject extends Password {
    @Override
    public String getTypeOfObject() {
        return this.getClass().getSimpleName();
    }

    @Override
    public Password getPresentObject() {
        return this;
    }
}
