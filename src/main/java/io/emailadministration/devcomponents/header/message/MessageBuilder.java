package io.emailadministration.devcomponents.header.message;

import io.emailadministration.devcomponents.auxiliary.checks.SanityChecks;
import io.emailadministration.devcomponents.auxiliary.position.CPosition;

public class MessageBuilder {
    private IStylizedMessage message;

    public MessageBuilder() {
        this.message = new HMessage();
    }

    public MessageBuilder setupPosition(CPosition position) {
        message.stylizedMessageAttributes().setPosition(SanityChecks.checkPosition(position));
        return this;
    }

    public MessageBuilder setupHeaderMessage(String headerMessage) {
        message.stylizedMessageAttributes().setHeaderMessage(headerMessage);
        return this;
    }

    public MessageBuilder setupIsMainMessage(boolean isMainMessage) {
        message.stylizedMessageAttributes().setMainMessage(isMainMessage);
        return this;
    }

    public MessageBuilder setupMessageStyle(MessageStyle style) {
        message.stylizedMessageAttributes().setStyle(style);
        return this;
    }

    public MessageBuilder addStyleToTheMessage(boolean withPosition, boolean withStyle) {
        message.stylizedMessageAttributes().stylizeIt(withPosition, withStyle);
        return this;
    }

    public IStylizedMessage build() {
        return message;
    }
}
