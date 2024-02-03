package io.emailadministration.devcomponents.menu.auxmessage;

import io.emailadministration.devcomponents.auxiliary.position.CPosition;
import io.emailadministration.devcomponents.auxiliary.checks.SanityChecks;
import io.emailadministration.devcomponents.auxiliary.position.CPositionNullObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuxiliaryMessage implements IAuxMessage {
    private String messageTheTheBottom;
    private CPosition position;
    private String processedAuxiliaryMessage;

    public AuxiliaryMessage() {
        this.messageTheTheBottom = "none";
        this.position = new CPositionNullObject();
        this.processedAuxiliaryMessage = "none";
    }

    public AuxiliaryMessage(String messageTheTheBottom, CPosition position) {
        this();

        this.messageTheTheBottom = SanityChecks.formattingTheMessage(messageTheTheBottom, false, false);
        this.position = SanityChecks.checkPosition(position);

        processTheAuxMessageWithPosition();
    }

    public AuxiliaryMessage(IAuxMessage auxiliaryMessage) {
        this.messageTheTheBottom = new String(auxiliaryMessage.auxiliaryMessageAttributes().getMessageTheTheBottom());
        this.position = new CPosition(auxiliaryMessage.auxiliaryMessageAttributes().getPosition());
        this.processedAuxiliaryMessage = new String(auxiliaryMessage.auxiliaryMessageAttributes().getProcessedAuxiliaryMessage());
    }

    private AuxiliaryMessage processTheAuxMessageWithPosition() {
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
    public AuxiliaryMessage getPresentObject() {
        return this;
    }

    public IAuxMessage getCopyInstance(IAuxMessage object) {
        return new AuxiliaryMessage(object);
    }

    @Override
    public AuxiliaryMessage auxiliaryMessageAttributes() {
        return this;
    }

    @Override
    public String getProcessedAuxiliaryMessage() {
        return processedAuxiliaryMessage;
    }

    @Override
    public CPosition getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return processedAuxiliaryMessage;
    }
}
