package io.emailadministration.devcomponents.auxiliary.Position;

public class CPositionNullObject extends CPosition {
    @Override
    public String addPositionToMessage(String message) {
        return this.getClass().getSimpleName();
    }

    public String getTypeOfObject() {
        return this.getClass().getSimpleName();
    }
}
