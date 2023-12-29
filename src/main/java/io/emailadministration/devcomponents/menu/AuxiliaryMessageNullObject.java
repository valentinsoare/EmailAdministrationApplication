package io.emailadministration.devcomponents.menu;

public class AuxiliaryMessageNullObject implements IAuxMessage {
    @Override
    public String getTypeOfObject() {
        return this.getClass().getSimpleName();
    }
}
