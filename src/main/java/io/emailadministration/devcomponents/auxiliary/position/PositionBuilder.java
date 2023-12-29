package io.emailadministration.devcomponents.auxiliary.position;

import io.emailadministration.devcomponents.header.message.MessageBuilder;

public class PositionBuilder {
    private CPosition position;

    public PositionBuilder() {
        this.position = new CPosition();
    }

    public PositionBuilder setupWhiteSpaceUp(int whiteSpaceUp) {
        position.setWhiteSpaceUp(whiteSpaceUp);
        return this;
    }

    public PositionBuilder setupWhiteSpaceDown(int whiteSpaceDown) {
        position.setWhiteSpaceDown(whiteSpaceDown);
        return this;
    }

    public PositionBuilder setupWhiteSpaceLeft(int whiteSpaceLeft) {
        position.setWhiteSpaceLeft(whiteSpaceLeft);
        return this;
    }

    public PositionBuilder setupWhiteSpaceRight(int whiteSpaceRight) {
        position.setWhiteSpaceRight(whiteSpaceRight);
        return this;
    }

    public CPosition build() {
        return position;
    }
}
