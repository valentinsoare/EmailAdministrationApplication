package io.emailadministration.devcomponents.menu;

import io.emailadministration.devcomponents.auxiliary.Position.CPosition;
import io.emailadministration.devcomponents.auxiliary.checks.SanityChecks;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AuxiliaryMessage implements IAuxMessage {
    private String messageTheTheBottom;
    private CPosition position;
    private String processedAuxiliaryMessage;

    public AuxiliaryMessage() {
        this.processedAuxiliaryMessage = messageTheTheBottom;
    }

    public AuxiliaryMessage(String messageTheTheBottom, CPosition position) {
        this();

        this.messageTheTheBottom = SanityChecks.formattingTheMessage(messageTheTheBottom, false, false);
        this.position = SanityChecks.checkPosition(position);
    }

    public AuxiliaryMessage processTheAuxMessageWithPosition() {
        StringBuilder sb = new StringBuilder();

        this.processedAuxiliaryMessage = sb.append("\n".repeat(position.getWhiteSpaceUp()))
                .append(" ".repeat(position.getWhiteSpaceLeft()))
                .append(messageTheTheBottom)
                .append(" ".repeat(position.getWhiteSpaceRight()))
                .append("\n".repeat(position.getWhiteSpaceDown())).toString();

        return this;
    }

    @Override
    public String getTypeOfObject() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return processedAuxiliaryMessage;
    }
}
