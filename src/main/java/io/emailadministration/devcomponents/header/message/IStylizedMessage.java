package io.emailadministration.devcomponents.header.message;

import io.emailadministration.devcomponents.Component;

import java.util.Optional;

public interface IStylizedMessage extends Component<IStylizedMessage> {
    Optional<IStylizedMessage> stylizeIt(boolean withPosition, boolean withStyle);
    HMessage stylizedMessageAttributes();
}
