package io.emailadministration.devcomponents.header.message;

import java.util.Optional;

public interface IStylizedMessage {
    Optional<IStylizedMessage> stylizeIt(boolean withPosition, boolean withStyle);
    HMessage stylizedMessageAttributes();
}
