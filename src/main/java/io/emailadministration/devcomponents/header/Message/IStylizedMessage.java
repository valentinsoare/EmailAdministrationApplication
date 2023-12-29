package io.emailadministration.devcomponents.header.Message;

import java.util.Optional;

public interface IStylizedMessage {
    Optional<IStylizedMessage> stylizeIt(boolean withPosition, boolean withStyle);
    HMessage getCustomizedMessage();
}
