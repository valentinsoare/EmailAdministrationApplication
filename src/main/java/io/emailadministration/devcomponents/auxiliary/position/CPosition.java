package io.emailadministration.devcomponents.auxiliary.position;

import io.emailadministration.devcomponents.auxiliary.checks.AppliedToArea;
import io.emailadministration.devcomponents.auxiliary.checks.SanityChecks;
import lombok.Getter;

@Getter
public class CPosition {
    private int whiteSpaceUp;
    private int whiteSpaceDown;
    private int whiteSpaceLeft;
    private int whiteSpaceRight;

    public CPosition() {}

    public CPosition(int whiteSpaceUp, int whiteSpaceDown,
                     int whiteSpaceLeft, int whiteSpaceRight) {
        setWhiteSpaceUp(whiteSpaceUp);
        setWhiteSpaceDown(whiteSpaceDown);
        setWhiteSpaceLeft(whiteSpaceLeft);
        setWhiteSpaceRight(whiteSpaceRight);
    }

    public CPosition(CPosition position) {
        this.whiteSpaceUp = position.getWhiteSpaceUp();
        this.whiteSpaceDown = position.getWhiteSpaceDown();
        this.whiteSpaceLeft = position.getWhiteSpaceLeft();
        this.whiteSpaceRight = position.getWhiteSpaceRight();
    }

    public String addPositionToMessage(String message) {
        StringBuilder sb = new StringBuilder();

        sb.append("\n".repeat(this.whiteSpaceUp))
                .append(" ".repeat(whiteSpaceLeft))
                .append(message)
                .append(" ".repeat(whiteSpaceRight))
                .append("\n".repeat(whiteSpaceDown));

        return sb.toString();
    }

    public void setWhiteSpaceUp(int whiteSpaceUp) {
        this.whiteSpaceUp =
                SanityChecks.validatePosition(whiteSpaceUp, AppliedToArea.UP);
    }

    public void setWhiteSpaceDown(int whiteSpaceDown) {
        this.whiteSpaceDown =
                SanityChecks.validatePosition(whiteSpaceDown, AppliedToArea.DOWN);
    }

    public void setWhiteSpaceLeft(int whiteSpaceLeft) {
        this.whiteSpaceLeft =
                SanityChecks.validatePosition(whiteSpaceLeft, AppliedToArea.LEFT);
    }

    public void setWhiteSpaceRight(int whiteSpaceRight) {
        this.whiteSpaceRight =
                SanityChecks.validatePosition(whiteSpaceRight, AppliedToArea.RIGHT);
    }

    public String getTypeOfObject() {
        return this.getClass().getSimpleName();
    }
}
