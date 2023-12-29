package io.emailadministration.devcomponents.menu.auxmessage;

public class AuxiliaryMessageNullObject extends AuxiliaryMessage {
    @Override
    public String getTypeOfObject() {
        return this.getClass().getSimpleName();
    }

    @Override
    public AuxiliaryMessage auxiliaryMessageAttributes() {
        return this;
    }
}
