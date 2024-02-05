package io.emailadministration.devcomponents.auxiliary.position;

public class CPositionNullObject extends CPosition {
    @Override
    public String addPositionToMessage(String message) {
        return this.getClass().getSimpleName();
    }

    public String getTypeOfObject() {
        return this.getClass().getSimpleName();
    }

    @Override
    public CPosition getPresentObject() {
        return this;
    }
}
