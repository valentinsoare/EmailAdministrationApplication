package io.emailadministration.devcomponents.header.message;

import io.emailadministration.devcomponents.Component;

import java.util.Optional;

public interface IStylizedMessage extends Component {
    Optional<IStylizedMessage> stylizeIt(boolean withPosition, boolean withStyle);
    HMessage stylizedMessageAttributes();
}
