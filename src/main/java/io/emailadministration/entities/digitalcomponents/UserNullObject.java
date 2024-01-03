package io.emailadministration.entities.digitalcomponents;

public class UserNullObject extends User {

    @Override
    public String getUserName() {
        return "Not selected";
    }

    @Override
    public String getTypeOfObject() {
        return this.getClass().getSimpleName();
    }
}
