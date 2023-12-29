package io.emailadministration.devcomponents.header.message;

import java.util.Optional;

public class HMessageNullObject extends HMessage {
    @Override
    public Optional<IStylizedMessage> stylizeIt(boolean withPosition, boolean withStyle) {
        return Optional.empty();
    }

    public String getTypeOfObject() {
        return this.getClass().getSimpleName();
    }
}
